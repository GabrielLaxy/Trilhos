import java.util.Scanner;

public class Main {

    static class No {
        private int info;
        private No proximo;

        public No(int info) {
            setInfo(info);
            proximo = null;
        }

        public int getInfo() {
            return info;
        }

        public No getProximo() {
            return proximo;
        }

        public void setInfo(int info) {
            this.info = info;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }

        @Override
        public String toString() {
            return "|" + info + "|->";
        }
    }

    static class Pilha {
        private No topo;

        public boolean estaVazio() {
            return topo == null;
        }

        public void push(int i) {
            No novo = new No(i);
            if (!estaVazio()) {
                novo.setProximo(topo);
            }
            topo = novo;
        }

        public int peek() {
            if (estaVazio()) {
                throw new IllegalStateException("A pilha está vazia");
            }
            return topo.getInfo();
        }

        @Override
        public String toString() {
            String s = "pilha: ";
            if (estaVazio()) {
                s += "vazia";
            } else {
                No aux = topo;
                while (aux != null) {
                    s = s + aux + "\n";
                    aux = aux.getProximo();
                }
                s = s + "\\\\";
            }
            return s;
        }

        public int pop() {
            if (estaVazio()) {
                throw new IllegalStateException("A pilha está vazia");
            }
            int temp = topo.getInfo();
            topo = topo.getProximo();
            return temp;
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
                p.topo = null;
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
                            if (!p.estaVazio() && p.peek() == fora)
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
