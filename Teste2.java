public class Teste2 {
    

    class No{
        private int info;
        private No proximo;
    
    
        public No (int info){
            setInfo(info);
            proximo = null;
        }
    
        public int getInfo() {
            return info;
        }
    
        public No getProximo() {
            return proximo;
        }
    
        public void setInfo(int info){
            this.info = info;
        }
    
        public void setProximo(No proximo){
            this.proximo = proximo;
        }
    
        @Override
        public String toString(){
            return "|" + info + "|->";
        }
    }
    
    
     class Pilha {
        private No topo;
        //construtor padrão
    
        public boolean estaVazio(){
            return topo==null;
        }
    
        public void push(int i){
            No novo = new No(i);
            if (!estaVazio()) {
                novo.setProximo(topo);
            }
            topo = novo;
        }
        
        public int peek(){
            return topo.getInfo();
        }
    
        @Override
        public String toString() {
            String s = "pilha: ";
            if(estaVazio()){
                s += "vazia";
            }else{
                No aux = topo;
                while(aux!=null){ 
                    s = s + aux + "\n";
                    aux = aux.getProximo();
                }
                s = s + "\\\\";
            }
            return s;
        }
    
        public int pop(){
            int temp = topo.getInfo();
            topo = topo.getProximo();
            return temp;
        }
    
    }
}
