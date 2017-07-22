package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr07_CollectCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // ArrayList<ArrayList<Character>> jaggedMatrix = new ArrayList<>();

        char[][] jaggedMatrix = new char[4][];

        for (int row = 0; row < 4; row++) {
            char[] line = scanner.nextLine().toCharArray();
            jaggedMatrix[row] = new char[line.length];
            for (int col = 0; col < line.length; col++) {
                jaggedMatrix[row][col] = line[col];
            }
        }



        int currRow = 0;
        int currCol = 0;
        int oldCol = 0;
        int coins = 0;
        int oldRow = 0;

        int hits = 0;

        char[] moves = scanner.nextLine().toCharArray();

        for (int move = 0; move < moves.length; move++) {
            switch (moves[move]){
                case 'V':
                    try {
                        oldRow = currRow;
                        currRow = currRow + 1;
                        if(jaggedMatrix[currRow][currCol] == '$'){
                            coins++;
                        }

                    }catch(IndexOutOfBoundsException e){
                        currRow = oldRow;
                        hits++;
                        continue;
                    }
                    break;
                case '>':
                    try {
                        oldCol = currCol;
                        currCol = currCol + 1;
                        if(jaggedMatrix[currRow][currCol] == '$'){
                            coins++;
                        }

                    }catch (IndexOutOfBoundsException e){
                        currCol = oldCol;
                        hits++;
                        continue;
                    }
                    break;
                case '<':
                    try {
                        oldCol = currCol;
                        currCol = currCol- 1;
                        if(jaggedMatrix[currRow][currCol] == '$'){
                            coins++;
                        }
                    }catch (IndexOutOfBoundsException e){
                        currCol = oldCol;
                        hits++;
                        continue;
                    }
                    break;
                case '^':
                    try {
                        oldRow = currRow;
                        currRow = currRow - 1;
                        if(jaggedMatrix[currRow][currCol] == '$'){
                            coins++;
                        }
                    }catch (IndexOutOfBoundsException e){
                        currRow = oldRow;
                        hits++;
                        continue;
                    }
                    break;
            }
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = "+ hits);
    }
}
