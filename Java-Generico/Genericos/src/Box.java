public class Box<T> {
    
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
