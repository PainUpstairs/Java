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

public class _8_queen {
    static Boolean done = false;

    public static ArrayList<Database> TheFunc(int num, Database database) {
        ArrayList<Database> answer = new ArrayList<>();
        if (database.getHorizontal().size() == num) {
            answer.add(database);
            done = true;
            return answer;
        }

        for (int i = 0; i < num; i++) {
            if (database.Contains1(i)) {
                for (int j = 0; j < num; j++) {
                    int right = (j + i);
                    int left = (j - i);

                    if (left < 0)
                        left = (left - (num - 1)) * -1;

                    if (database.Contains2(j, right, left)) {
                        Database forward_database = new Database(database);
                        forward_database.AddTo(right, left, j, i);
                        answer.addAll(TheFunc(num, forward_database));
                        if (done)
                            break;
                    }
                }
            }
            if (done)
                break;
        }
        return answer;
    }

    public static void main(String args[]) {
        ArrayList<Database> answer = new ArrayList<>();
        Database database = new Database();
        int num = 8;

        for (int i = 0; i < num / 4; i++) {
            if (database.Contains1(i)) {
                for (int j = 0; j < num / 2; j++) {
                    int right = (j + i);
                    int left = (j - i);

                    if (left < 0)
                        left = (left - (num - 1)) * -1;

                    if (database.Contains2(j, right, left)) {
                        Database forward_database = new Database(database);
                        forward_database.AddTo(right, left, j, i);
                        answer.addAll(TheFunc(num, forward_database));
                    }
                }
            }
        }

        ArrayList<Integer> position = new ArrayList<>();
        for (Database d : answer) {
            for (int i = 0; i < d.getHorizontal().size(); i++) {
                position.add(num * d.getHorizontal().get(i) + d.getVertical().get(i));
            }
        }

        System.out.print("Answer-> ");
        for (Integer i : position)
            System.out.print(i+" ");

        for (int i = 0; i < num * num; i++) {
            if (i % num == 0)
                System.out.println();
            if (position.contains(i))
                System.out.print("  Q  ");
            else
                System.out.print(" [ ] ");
        }

    }
}