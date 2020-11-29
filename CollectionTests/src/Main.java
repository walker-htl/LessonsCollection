import java.util.*;

public class Main {

    public static void main(String[] args) {
        //ArrayList();
        //LinkedList();
        //ListIterator();
        //HashTable();
        //HashSet();
        //TreeSet();
        SetOperation();
    }

    private static void SetOperation() {
        System.out.println();
        System.out.println("Set operations - better understandig!");
        System.out.println();

        TreeSet<Integer> setA = new TreeSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        printSet("A", setA);

        TreeSet<Integer> setB = new TreeSet<>();
        setB.add(4);
        setB.add(5);
        setB.add(6);
        setB.add(7);
        setB.add(8);
        printSet("B", setB);

        TreeSet<Integer> setC = new TreeSet<>();
        setC.add(7);
        printSet("C", setC);

        // Union of sets (Vereinigung von Mengen)
        setA.addAll(setB);
        printSet("union(A,B)", setA);

        // Difference of sets (Differenz von Mengen)
        setA.removeAll(setB);
        printSet("diff(A,B)", setA);

        // we lost element 4 and 5
        setA.add(4);
        setA.add(5);
        printSet("setA added 2 elemnts", setA);

        // clone SetA to cloneSetA
        TreeSet<Integer> cloneSetA = (TreeSet<Integer>)setA.clone();
        printSet("clone setA", cloneSetA);

        // Intersection of stes (Scheiden von Mengen)
        setA.retainAll(setB);
        printSet("intersect(A,B)", setA);

        // Contain
        System.out.println("Does setA contain C: " + setA.containsAll(setC));
        System.out.println("Does setB contain C: " + setB.containsAll(setC));
    }

    private static void printSet(String name, TreeSet<Integer> setA) {
        System.out.print(name+": ");
        for (Integer element: setA) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    private static void TreeSet() {
        System.out.println();
        System.out.println("TreeSet - better understandig!");
        System.out.println();

        // Why does this code not work?
        //TreeSet<Person> testSet = new TreeSet<>();
        //testSet.add(new Person("A", "abyz", 25));
        //testSet.add(new Person("A", "abz[", 25));

        TreeSet<MyPerson> set = new TreeSet<>();
        set.add(new MyPerson("A", "abyz", 25));
        set.add(new MyPerson("A", "abz[", 25));
        set.add(new MyPerson("B", "aaa", 5));
        set.add(new MyPerson("B", "aba", 5));

        for (Person element:set) {
            System.out.println(element + ", hasCode: " + element.hashCode());
        }

        System.out.println();
        System.out.println("First Element: " + set.first());
        System.out.println("Last Element: " + set.last());

        System.out.println();
        System.out.println("Show all elements smaller then the last element");
        SortedSet<MyPerson> sortedSet = set.headSet(set.last());
        for (Person element:sortedSet) {
            System.out.println(element + ", hasCode: " + element.hashCode());
        }
    }

    private static void HashSet() {
        System.out.println();
        System.out.println("HashSet - better understandig!");
        System.out.println();

        Set<Person> set = new HashSet<>();
        set.add(new Person("A", "abyz", 25));
        set.add(new Person("A", "abyz", 25));
        set.add(new Person("A", "abz[", 25));
        set.add(new Person("B", "Greedy", 5));

        for (Person element:set) {
            System.out.println(element + ", hasCode: " + element.hashCode());
        }
    }

    private static void HashTable() {
        System.out.println();
        System.out.println("HashTable - better understandig!");
        System.out.println();

        Hashtable<String, String> table = new Hashtable<>();
        table.put("abcd", "0000");
        table.put("abyz", "1234");
        table.put("abz[", "4578");

        // possibility to see all elements
        System.out.println(table);

        System.out.println();
        System.out.println("Key iteration with equal keys");
        Iterator kIterator = table.keySet().iterator();

        while (kIterator.hasNext())
        {
            Object element = kIterator.next();
            System.out.println( "key: " + element + ", hashcode: " + element.hashCode());
        }

        System.out.println();
        System.out.println("Value iteration");
        Iterator vIterator = table.values().iterator();

        while (vIterator.hasNext())
        {
            Object element = vIterator.next();
            System.out.println( "value: " + element + ", hashcode: " + element.hashCode());
        }

        System.out.println();
        System.out.println("Entry iteration");
        Iterator eIterator = table.entrySet().iterator();

        while (eIterator.hasNext())
        {
            Object element = eIterator.next();
            System.out.println( "entry: " + element + ", hashcode: " + element.hashCode());
        }
    }

    private static void ListIterator() {
        System.out.println();
        System.out.println("ListIterator - backward iteration and methods");
        System.out.println();

        List<Smurf> smurfs = new ArrayList<>();
        smurfs.add(new Smurf(1, "Brainy", 25));
        smurfs.add(new Smurf(2, "Grouchy", 25));
        smurfs.add(new Smurf(3, "Clumsy", 15));
        smurfs.add(new Smurf(4, "Greedy", 5));
        smurfs.add(new Smurf(5, "Jokey", 9));

        System.out.println("Set iterator pointer to the end");
        ListIterator<Smurf> iterator = smurfs.listIterator(5);

        System.out.println();
        System.out.println("Add the Chef!");
        iterator.add(new Smurf(6, "Chef", 1));

        System.out.println("end --> start");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        System.out.println();
        System.out.println("Set the NewBrain!");
        iterator.set(new Smurf(1, "NewBrain", 25));
        System.out.println("start --> end");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void LinkedList() {
        System.out.println();
        System.out.println("Linked List - Iterator forward backward");
        System.out.println();

        // Must be a linked list, not "only" a list
        LinkedList<String> llist = new LinkedList<>();

        llist.add("A");
        llist.add("B");
        llist.add("C");
        llist.add("D");

        Iterator iterator = llist.listIterator();

        System.out.println("start --> end");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Iterator iter = llist.descendingIterator();

        System.out.println("end --> start");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static void ArrayList() {
        System.out.println("ArrayList and its Collection methods");
        System.out.println();

        List<String> arrList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            arrList.add("Obj" + i);
        }

        // add
        arrList.add("Max");

        // contains
        System.out.println("Is \"Max\" in the array?: " + arrList.contains("Max"));

        // equals
        System.out.println("Is the string \"Max\" equals an array?: " + arrList.equals("Max"));
        List<String> refToArrList = arrList;
        System.out.println("Is refToArrList equals to arrList?: " + arrList.equals(refToArrList));

        // let's make a copy:
        List<String> arrList2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arrList2.add("Obj" + i);
        }

        // add
        arrList2.add("Max");

        // equals
        System.out.println("Is arrList equals to arrList2?: " + arrList.equals(arrList2));

        // hashCode
        System.out.println("arrList: " + arrList.hashCode());
        System.out.println("arrList2: " + arrList2.hashCode());

        // remove
        arrList2.remove("Obj1");

        // hashCode
        System.out.println("arrList: " + arrList.hashCode());
        System.out.println("arrList2: " + arrList2.hashCode());

        // isEmpty
        List<String> arrList3 = new ArrayList<>();
        System.out.println("Is arrList3 empty?: "+ arrList3.isEmpty());
        System.out.println("Is arrList2 empty?: "+ arrList2.isEmpty());

        // clear
        arrList2.clear();
        System.out.println("Is arrList2 empty?: "+ arrList2.isEmpty());

        //String[] array = (String[]) arrList.toArray();
        //String[] array2 = arrList2.toArray(new String[]{"3", "2"});
        //System.out.println(array);
        //System.out.println(array2);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        Object[] objectArray = list.toArray();
        System.out.println(objectArray.toString());

        Integer[] integerArray = new Integer[list.size()];
        list.toArray(integerArray);

        Integer[] integerArray2 = list.toArray(new Integer[0]);
        System.out.println(integerArray2.toString());

        List<Boolean> boolList = new LinkedList<Boolean>();
        boolList.add(true);
        boolList.add(false);

        Iterator<Boolean> iter = boolList.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        List<Integer>  llist = Arrays.asList(3,6,4,32,6,4,312,2);
        System.out.println("Alternative in printing a list:");
        llist.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}