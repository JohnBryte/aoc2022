package day21;

public class MonkeyDay21 {

    private final String name;
    private String left;
    private String right;
    private String operator;
    private Long result = null;
    private String parent = null;

    public MonkeyDay21(String name, Long result) {
        this.name = name;
        this.result = result;
    }

    public MonkeyDay21(String name, String left, String operator, String right) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public void doOperation(Long left, Long right) {
        switch (operator) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public long doOperationInverseLeft(Long target, Long right) {
        switch (operator) {
            case "+":
                // x = y + z
                // y = z - x
                result = target - right;
                break;
            case "-":
                // x = y - z
                // y = x + z
                result = target + right;
                break;
            case "*":
                // x = y * z
                // y = x / z
                result = target / right;
                break;
            case "/":
                // x = y / z
                // y = x * z
                result = target * right;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

    public long doOperationInverseRight(Long target, Long left) {
        switch (operator) {
            case "+":
                // x = y + z
                // z = y - x
                result = target - left;
                break;
            case "-":
                // x = y - z
                // z = x + z
                result = (target - left) * -1;
                break;
            case "*":
                // x = y * z
                // z = x / y
                result = target / left;
                break;
            case "/":
                // x = y / z
                // z = y / x
                result = target * left;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }


    public String getName() {
        return name;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getOperator() {
        return operator;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
