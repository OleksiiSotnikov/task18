package task18;

public class Game {
    int top;
    int heft;
    public int[][] plank;

    Game(int height, int weight) {
        this.top = height;
        this.heft = weight;
        this.plank = new int[height][weight];
    }

    void printPlank() throws InterruptedException {
        for (int i = 0; i < heft; i++) {
            System.out.print("|");
            for (int j = 0; j < top; j++) {
                if (this.plank[j][i] == 1) {
                    System.out.print(" @ ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println("|");
        }
        System.out.println("--------------------------------------------------------------");
        Thread.sleep(1500);
    }

    public void operate() {
        int[][] nextPlank = new int[top][heft];
        for (int i = 0; i < top; i++) {
            for (int j = 0; j < heft; j++) {
                int numberOfNeighbours = neighbours(j, i);
                if (error(j, i) == 1) {
                    if (numberOfNeighbours < 2) {
                        nextPlank[j][i] = 0;
                    }
                    if (numberOfNeighbours == 2 || numberOfNeighbours == 3) {
                        nextPlank[j][i] = 1;
                    }
                    if (numberOfNeighbours > 3) {
                        nextPlank[j][i] = 0;
                    }
                } else {
                    if (numberOfNeighbours == 3) {
                        nextPlank[j][i] = 1;
                    }

                }
            }
        }
        this.plank = nextPlank;
    }

    public void live(int x, int y) {
        this.plank[y][x] = 1;
    }

    public int neighbours(int x, int y) {
        int counter = 0;
        counter += error(x + 1, y);
        counter += error(x, y + 1);
        counter += error(x + 1, y + 1);
        counter += error(x - 1, y - 1);
        counter += error(x - 1, y);
        counter += error(x - 1, y + 1);
        counter += error(x, y - 1);
        counter += error(x + 1, y - 1);
        return counter;
    }

    int error(int x, int y) {
        try {
            return plank[x][y];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return 0;
        }
    }

}
