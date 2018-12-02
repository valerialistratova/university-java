import java.util.Arrays;
import java.util.Random;

public class Main{
    public static void main(String [] args){
        System.out.println("Лiстратова В. С.");
        calculateMatrix(createMatrix());
    }


    private static short[][] createMatrix(){
        short[][] matrix = new short[7][7];
        Random random = new Random();

        System.out.println();
        System.out.println("Вихiдна матриця:");


        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = (short) random.nextInt();
                System.out.printf("%8d",matrix[i][j]);
            }
            System.out.println();
        }
        return  matrix;
    }

    private static void calculateMatrix(short[][] inputMatrix){
        short [] biggestValueOfColumn = new short[7];
        short [] biggestValueOfRaw = new short[7];
        short max;

        System.out.println();
        System.out.println("Найбiльшi значення у кожному стовпцi: ");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                biggestValueOfRaw[j] = inputMatrix[j][i];
            }
            Arrays.sort(biggestValueOfRaw);
            biggestValueOfColumn[i] = biggestValueOfRaw[6];
            System.out.print(biggestValueOfColumn[i] + "   ");
        }
        System.out.println();

        max = biggestValueOfColumn[0];
        for (int i = 0; i < 7; i++) {
            if (max < biggestValueOfColumn[i]) {max = biggestValueOfColumn[i];}
        }

        for (int i = 0; i < 7; i++) {
            if (max == biggestValueOfColumn[i]){
                System.out.println("Найбiльше число " + max + " знаходиться у " + (i+1) + " стовпцi");
                shrinkMatrix(inputMatrix, i);
                break;
            }
        }
    }

    private static short[][] shrinkMatrix(short[][] inputMatrix, int i){
        short[][] outputMatrix = new short[6][7];
        System.out.println();
        System.out.println("Пiсля видалення стовпця " + (i+1) + " отримали наступний результат: ");
        for (int j = 0, currColumn = 0; j < 7; j++) {
            for (int k = 0; k < 7; k++) {
                if (k!=i){
                    outputMatrix[currColumn][k] = inputMatrix[j][k];
                    System.out.printf("%8d", outputMatrix[currColumn][k]);
                }
            }
            System.out.println();
        }
        for (short[] anOutputMatrix : outputMatrix) {
            for (int k = 0; k < outputMatrix.length; k++) {
                System.out.printf("%8d", anOutputMatrix[k]);
            }
        }
        return outputMatrix;
    }
}