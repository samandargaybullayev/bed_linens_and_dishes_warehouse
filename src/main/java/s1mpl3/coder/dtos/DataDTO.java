package s1mpl3.coder.dtos;

public class DataDTO<T> {
    private T body;
    private boolean success;
    private AppErrorDTO errorDTO;

    public DataDTO(AppErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
        this.success = false;
    }

    public DataDTO(T body) {
        this.body = body;
        this.success = true;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public AppErrorDTO getErrorDTO() {
        return errorDTO;
    }

    public void setErrorDTO(AppErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }
}
