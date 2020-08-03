package com.example.service;

import java.io.*;

/**
 * @Author: wanqian
 * @Date: 2020/7/31 16:23
 */
public class SparseArrayService {

    public static void main(String[] args) {

        int[][] iniArray = new int[10][9];
        iniArray[1][3] = 5;
        iniArray[3][3] = 4;
        iniArray[5][7] = 3;
        iniArray[9][8] = 10;

        int i = printArray(iniArray);
        System.out.println("---------原数组---------");
        System.out.println();

        int[][] parseArr = compressSparse(iniArray, i);
        System.out.println("---------压缩完成---------");
        System.out.println();

        String path = saveArr(parseArr);
        System.out.printf("---------保存完成: %s----------\n", path);
        System.out.println();

        parseArr = loadArr(path);
        int[][] ints = decompressSparse(parseArr);

        System.out.println("---------解压完成---------");
    }


    /**
     * 压缩成稀疏数组
     *
     * @param iniArray
     * @param num
     * @return
     */
    public static int[][] compressSparse(int[][] iniArray, int num) {
        int[][] sparse = new int[num + 1][3];
        sparse[0][0] = iniArray.length;
        sparse[0][1] = iniArray[1].length;
        sparse[0][2] = num;
        int row = 0;
        for (int i = 0; i < iniArray.length; i++) {
            for (int j = 0; j < iniArray[1].length; j++) {
                if (iniArray[i][j] != 0) {
                    row++;
                    sparse[row][0] = i;
                    sparse[row][1] = j;
                    sparse[row][2] = iniArray[i][j];
                }
            }
        }
        printArray(sparse);
        return sparse;
    }

    /**
     * 解压缩稀疏数组
     *
     * @param sparseArray
     * @return
     */
    public static int[][] decompressSparse(int[][] sparseArray) {
        int[][] iniArr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            iniArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        printArray(iniArr);
        return iniArr;
    }

    /**
     * 打印数组
     *
     * @param array
     * @return
     */
    public static int printArray(int[][] array) {
        int num = 0;
        for (int[] i : array) {
            for (int j : i) {
                System.out.printf(String.format("%d\t", j));
                if (j != 0) {
                    num++;
                }
            }
            System.out.println();
        }
        System.out.println("有效数字" + num + "个");
        return num;
    }

    public static String saveArr(int[][] array) {
        File file = new File("array.bak");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(array);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    private static int[][] loadArr(String path) {
        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            int[][] ints = (int[][]) ois.readObject();
            return ints;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
