package s1mpl3.coder.dtos;

public class ResponseEntity<T> {
    private final T data;
    private Integer status;

    public ResponseEntity(T data) {
        this.data = data;
    }

    public ResponseEntity(T data, Integer status) {
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
