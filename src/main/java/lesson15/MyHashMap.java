package lesson15;

public class MyHashMap implements MyMap{
    private int size = 0; // количество пар в контейнере
    private static final int INITIAL_CAPACITY = 4; // начальный размер массива
    private static final double LOAD_FACTOR = 0.75; // коэффициент загруженности
    // если size/source.length >= LOAD_FACTOR то нужно перебалансировать
    // для равномерного распределения элементов чтобы не было длинных цепочек

    private Pair [] source = new Pair[INITIAL_CAPACITY]; // массив для хранения "голов" цепочек

    public int capacity()
    {
        return source.length;
    }

    private static class Pair { // элемент
        String key; // ключ
        String value; // значение
        Pair next; // ссылка на следующий элемент в цепочке

        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Pair getNext() {
            return next;
        }

        public void setNext(Pair next) {
            this.next = next;
        }
    }
        

    @Override
    public void put(String key, String value) {
        if(size > LOAD_FACTOR*source.length)
            resize();
        Pair pair = findPair(key); // поиск пары по ключу
        if(pair == null) // нужно вставить новую пару
        {
            int bucket = findBucket(key); // найдем номер ведра по ключу
            pair = new Pair(key, value, source[bucket]);
            source[bucket] = pair; // делаем новую пару корнем цепочки
            size++;
        }
        else {
            pair.value = value; // такая пара уже есть, просто меняем значение
        }
        
    }

    private void resize()
    {
        // нужно создать новый массив длины в два раза больше чем source
        // пробежаться по всем корневым элементам и перенести их
        // в нужные бакеты нового массива
        Pair [] newSource = new Pair[source.length * 2]; // новый массив
        for(Pair p : source) // корень текущего
        {
            Pair c = p;
            while (c != null) // текущая пара
            {
                Pair n  = c.next;
                int bucket = Math.abs(c.key.hashCode()) % newSource.length;
                c.next = newSource[bucket];
                newSource[bucket] = c;
                c = n;
            }
        }
        source = newSource;
    }

    private int findBucket(String key) {
        return Math.abs(key.hashCode()) % source.length;
    }

    private Pair findPair(String key) {
        // найдем ведро по ключу
        int bucket = findBucket(key);
        Pair currentPair = source[bucket]; // корень цепочки
        while (currentPair != null)
        {
            if(currentPair.key.equals(key))
                return currentPair;
            currentPair = currentPair.next; // следующая пара по цепочке
        }
        return null; // пара с ключом key не найдена
    }

    @Override
    public String get(String key) {
        Pair pair = findPair(key);
        if(pair == null)
            return null;
        return pair.value;
    }

    @Override
    public String remove(String key) {
        if(this.contains(key)){
            int i = findBucket(key);
            Pair p = source[i];
            if(p.getKey().equals(key)){
                source[i] = p.getNext();
                p.setNext(null);
                --size;
                return key;
            }


            while (p.getNext() != null){
                Pair pairNext = p.getNext();
                if (pairNext.getKey().equals(key)){
                    p.setNext(pairNext.getNext());
                    pairNext.setNext(null);
                    --size;
                    return key;
                }
                p = pairNext;

            }
            return key;
        }
        return null;
    }

    /*@Override
    public String remove(String key) {
        int bucket = findBucket(key);
        Pair c = source[bucket];
        if(c == null)
            return null;
        if(c.key.equals(key))
        {
            source[bucket]  = c.next;
            size--;
            return c.value;
        }
        while (c.next != null)
        {
            if(c.next.key.equals(key))
            {
                Pair toDelete = c.next;
                c.next = toDelete.next;
                size--;
                return toDelete.value;
            }
            c = c.next;
        }
        return null;
    }
*/

    @Override
    public boolean contains(String key) {
        return this.get(key) != null;
    }


    @Override
    public int size() {
        return size;
    }
}
