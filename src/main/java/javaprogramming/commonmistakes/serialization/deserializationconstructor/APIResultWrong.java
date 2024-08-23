package javaprogramming.commonmistakes.serialization.deserializationconstructor;

import lombok.Data;

@Data
public class APIResultWrong {
    private boolean success;
    private int code;

    public APIResultWrong() {
    }

    public APIResultWrong(int code) {
        this.code = code;
        success = code == 2000;
    }
}
