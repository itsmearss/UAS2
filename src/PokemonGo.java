import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PokemonGo {
    private String[] data;

    public void setData(String[] data){
        this.data = data;
    }

    private int partition (int start, int end){
        String pivot  = this.data[end];
        int i  = (start - 1);
        for (int j = start; j <= end - 1; j++){
            if (this.data[j].compareToIgnoreCase(pivot) < 0){
                i++;
                String t = this.data[i];
                this.data[i] = this.data[j];
                this.data[i] = t;
            }
        }
        String t = this.data[i+1];
        this.data[i+1] = this.data[end];
        this.data[end] = t;
        return (i + 1);
    }

    public void quickSort(int start, int end){
        if (start < end){
            int p = partition(start, end);
            quickSort(start, p-1);
            quickSort(p+1, end);
        }
    }

    public void printArr(int n){
        int i;
        for (i = 0; i < n; i++){
            System.out.println(this.data[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> Pokemon = new ArrayList<>();
        Pokemon.ensureCapacity(5);
        Scanner i = new Scanner(System.in);
        String Bug[];
        Bug = new String[6];
        for(int s = 0; s < Bug.length; s++){
            System.out.println("Masukkan Nama ke " + s + ":");
            String nama = i.nextLine();
            Bug[s] = nama;
        }

        int n = Bug.length;
        System.out.println("Before Sorting array elements are -\s");
        PokemonGo _myQS = new PokemonGo();
        _myQS.setData(Bug);
        _myQS.printArr(n);
        _myQS.quickSort(0,  n-1);
        System.out.println("\nAfter  sorting array elements are - ");
        _myQS.printArr(n);
        System.out.println(" ");


    }
}

