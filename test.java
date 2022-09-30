import java.util.*;

class Database {
    ArrayList<Integer> diagonal_right = new ArrayList<>();
    ArrayList<Integer> diagonal_left = new ArrayList<>();
    ArrayList<Integer> horizontal = new ArrayList<>();// i
    ArrayList<Integer> vertical = new ArrayList<>();// j

    Database() {
    }

    Database(Database d) {
        this.diagonal_left = new ArrayList<>(d.getLeft());
        this.diagonal_right = new ArrayList<>(d.getRight());
        this.horizontal = new ArrayList<>(d.getHorizontal());
        this.vertical = new ArrayList<>(d.getVertical());
    }

    public void AddTo(int r, int l, int v, int h) {
        this.diagonal_left.add(l);
        this.diagonal_right.add(r);
        this.horizontal.add(h);
        this.vertical.add(v);
    }

    public ArrayList<Integer> getRight() {
        return diagonal_right;
    }

    public ArrayList<Integer> getLeft() {
        return diagonal_left;
    }

    public ArrayList<Integer> getHorizontal() {
        return horizontal;
    }

    public ArrayList<Integer> getVertical() {
        return vertical;
    }

    public Boolean Contains1(int h) {
        if (horizontal.contains(h))
            return false;
        else
            return true;
    }

    public Boolean Contains2(int v, int r, int l) {

        if (vertical.contains(v) || diagonal_right.contains(r) || diagonal_left.contains(l)) {
            // System.out.println("false");
            return false;
        } else {
            // System.out.println("true");
            return true;
        }
    }

    public void showData() {
        System.out.println("forward_diagonal_right ->" + diagonal_right);
        System.out.println("forward_diagonal_left  ->" + diagonal_left);
        System.out.println("forward_vertical       ->" + vertical);
        System.out.println("forward_horizontal     ->" + horizontal);
        System.out.println();
    }
}

public class test {
    // static int count = 0;

    public static ArrayList<Database> TheFunc(int num, ArrayList<Integer> store, Database database) {

        ArrayList<Database> answer = new ArrayList<>();
        if (store.size() == num) {
            answer.add(database);
            return answer;
        }

        for (int i = 0; i < num; i++) {
            if (database.Contains1(i)) {
                for (int j = 0; j < num; j++) {
                    int temp = i * num + j;
                    int right = (j + i);
                    int left = (j - i);

                    if (left < 0)
                        left = (left - (num - 1)) * -1;

                    if (database.Contains2(j, right, left)) {
                        ArrayList<Integer> forward_store = new ArrayList<>(store);
                        forward_store.add(temp);
                        // System.out.println("value-> " + (temp));
                        Database forward_database = new Database(database);
                        forward_database.AddTo(right, left, j, i);
                        // count++;
                        answer.addAll(TheFunc(num, forward_store, forward_database));
                        // // _flag = true;
                        break;

                    }
                }
            }
        }
        // System.out.println("Count->" + count);
        // database.showData();
        return answer;
    }

    public static void main(String args[]) {
        ArrayList<Database> answer = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>();
        Database database = new Database();
        int num = 8;

        for (int i = 0; i < num / 2; i++) {
            if (database.Contains1(i)) {
                for (int j = 0; j < num / 2; j++) {
                    int temp = i * num + j;
                    int right = (j + i);
                    int left = (j - i);

                    if (left < 0)
                        left = (left - (num - 1)) * -1;

                    if (database.Contains2(j, right, left)) {
                        ArrayList<Integer> forward_store = new ArrayList<>(store);
                        forward_store.add(temp);
                        // System.out.println("value-> " + (temp));
                        Database forward_database = new Database(database);
                        forward_database.AddTo(right, left, j, i);
                        // count++;
                        answer.addAll(TheFunc(num, forward_store, forward_database));
                        // // _flag = true;
                        break;

                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> position = new ArrayList<>();

        for (Database d : answer){
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < d.getHorizontal().size(); i++) {
                temp.add(num*d.getHorizontal().get(i) + d.getVertical().get(i));
            }
            position.add(temp);
        }
        System.out.print(position.size());
        // for( ArrayList<Integer> e: position ){
        //     System.out.println(e);
        // }

    }
}