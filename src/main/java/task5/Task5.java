package task5;

import static java.lang.Math.min;

public final class Task5 {
    private Task5(){
    }

    public static int solveTask5(int[][] triangle) {
        validateTriangle(triangle);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] = min(triangle[i][j] + triangle[i - 1][j - 1],
                            triangle[i][j] + triangle[i - 1][j]);
                }
                if (i == triangle.length - 1) {
                    res = min(res, triangle[i][j]);
                }
            }
        }
        return res;
    }

    private static void validateTriangle(int[][] triangle) {
        if (triangle[0].length != 1) {
            throw new IllegalArgumentException("Вершина треугольника должна состоять только из одного элемента");
        }
        int levelLength = 1;
        for (int i = 1; i < triangle.length; i++) {
            if (++levelLength != triangle[i].length) {
                throw new IllegalArgumentException("Структура треугольника нарушена");
            }
        }
    }
}
