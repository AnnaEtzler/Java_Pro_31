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

    private void resize() {
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
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
