public class thread {
    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();
        t1.setName("il tread del giofe");
        System.out.println("Thread in esecuzione: " + t1.getName());

        try{
            for(int i=0;i<5;i++){
                System.out.println("ci sto lavorando " + i+1);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("mi hanno interrotto");
        }
    }
}
