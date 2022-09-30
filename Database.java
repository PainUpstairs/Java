import java.util.*;

class Database{
    ArrayList<Integer> diagonal_right = new ArrayList<>();
    ArrayList<Integer> diagonal_left = new ArrayList<>();
    ArrayList<Integer> horizontal = new ArrayList<>();// i
    ArrayList<Integer> vertical = new ArrayList<>();//j

    Database(){}

    Database(Database d){
        this.diagonal_left = new ArrayList<>(d.getLeft());
        this.diagonal_right = new ArrayList<>(d.getRight());
        this.horizontal = new ArrayList<>(d.getHorizontal());
        this.vertical = new ArrayList<>(d.getVertical());
    }

    public void AddTo(int r, int l, int v, int h){
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

    public ArrayList<Integer> getHorizontal(){
        return horizontal;
    }

    public ArrayList<Integer> getVertical(){
        return vertical;
    }

    public Boolean Contains1(int h){
        if(horizontal.contains(h))
            return false;
        else
            return true;
    }

    public Boolean Contains2(int v, int r, int l){
        if(vertical.contains(v) || diagonal_right.contains(r) || diagonal_left.contains(l))
            return false;
        else
            return true;
    }

    public void showData(){
        System.out.println("forward_diagonal_right ->" + diagonal_right);
        System.out.println("forward_diagonal_left  ->" + diagonal_left);
        System.out.println("forward_vertical       ->" + vertical);
        System.out.println("forward_horizontal     ->" + horizontal);
        System.out.println();
    }
}