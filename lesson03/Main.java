package lesson03;

class Main {
    public static void main(String[] args) {
        int Len = 25;
        // Создаём двусвязный список
        MyList mylist = new MyList(Len);
        System.out.println(mylist.print());
        // Разворачиваем двусвязный список
        mylist.revert();
        System.out.println(mylist.print());
    }
}