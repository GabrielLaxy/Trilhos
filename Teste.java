import java.util.Scanner;

public class Teste {

    static int MAX = 1000;

    static class Pilha {
        int[] v = new int[MAX];
        int topo = -1;

        void push(int valor) {
            v[++topo] = valor;
        }

        void pop() {
            topo--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int vagoes = scanner.nextInt();
            if (vagoes == 0)
                break;

            Pilha p = new Pilha();

            while (true) {
                p.topo = -1;
                int entrando = 1, erro = 0, zero = 0;

                for (int i = 0; i < vagoes && erro == 0 && zero == 0; i++) {
                    int fora = scanner.nextInt();
                    if (fora == 0) {
                        zero = 1;
                        break;
                    }
                    while (true) {
                        if (fora == entrando) {
                            entrando++;
                            break;
                        } else if (fora > entrando) {
                            p.push(entrando);
                            entrando++;
                        } else {
                            if (p.v[p.topo] == fora)
                                p.pop();
                            else {
                                erro = 1;
                                for (; i < vagoes - 1; i++)
                                    scanner.nextInt();
                            }
                            break;
                        }
                    }
                }

                if (zero == 0) {
                    if (erro == 0)
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                } else {
                    break;
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}