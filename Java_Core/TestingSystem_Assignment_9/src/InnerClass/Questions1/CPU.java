package InnerClass.Questions1;

public class CPU {

    private Double price;
    CPU(Double price){
        this.price = price;
    }

    static class  Processor{

        private int coreAmount;
        private  String menuacturer;

        Processor(int coreAmount,String menuacturer){
            this.coreAmount = coreAmount;
            this.menuacturer = menuacturer;
        }

        public int getCoreAmount() {
            return coreAmount;
        }

        public void setCoreAmount(int coreAmount) {
            this.coreAmount = coreAmount;
        }

        public String getMenuacturer() {
            return menuacturer;
        }

        public void setMenuacturer(String menuacturer) {
            this.menuacturer = menuacturer;
        }

        public Double getCache(){
            return 4.3d;
        }

    }

     static class Ram{
        private String memory;
        private String menuacturer;

        Ram(String memory,String menuacturer){
            this.memory = memory;
            this.menuacturer = menuacturer;
        }

        public String getMemory() {
            return memory;
        }

        public void setMemory(String memory) {
            this.memory = memory;
        }

        public String getMenuacturer() {
            return menuacturer;
        }

        public void setMenuacturer(String menuacturer) {
            this.menuacturer = menuacturer;
        }

        public Double getClock(){
            return 5.5d;
        }
    }

    public static void main(String[] args) {

        CPU cpu = new CPU(2.3);

        CPU.Processor processor = new CPU.Processor(4,"adcas");
        System.out.println(processor.getCache());

        CPU.Ram ram = new CPU.Ram("8G","asd");
        System.out.println(ram.getClock());
    }
}
