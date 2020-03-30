import java.util.ArrayList;
import java.util.List;

public class Maximum {
    int max_no = Integer.MIN_VALUE;
    List<Node> maxSumPath = new ArrayList();

    public int getMaxNo(){
        return max_no;
    }

    public void setMaxNo(int currentSum){
        this.max_no = currentSum;

    }

    public List<Node> getMaxSumPath(){
        return maxSumPath;
    }

    public void setMaxSumPath(List<Node> maxSumPath){
        this.maxSumPath = maxSumPath;

    }


}