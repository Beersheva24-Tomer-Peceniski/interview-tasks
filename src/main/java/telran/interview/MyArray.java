package telran.interview;

public class MyArray<T> {
    private Object[] array;
    boolean settedAll = true;
    T allValue = null;

    public void setAll(T value) {
        settedAll = true;
        allValue = value;
    }

    public void set(int index, T value) {
        settedAll = false;
        allValue = null;
        array[index] = value;
    }

    public T get(int index) {
        return settedAll == true ? allValue : (T) array[index];
    }

    public MyArray(int size) {
        array = new Object[size];
    }
}