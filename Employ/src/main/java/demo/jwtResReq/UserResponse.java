package demo.jwtResReq;

public class UserResponse
{
    private String token;
    private String message;

    public UserResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "employResponse{" +
                "token='" + token + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public UserResponse() {
    }
}
