

public class TreeSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        StringBuilder aStr = new StringBuilder("");
        StringBuilder bStr = new StringBuilder("");
        aStr = scanTree(A, aStr);
        bStr = scanTree(B, bStr);
        String a = aStr.toString();
        String b = bStr.toString();
        boolean isSub = isMatch(a, b);
        return isSub;
    }

    public StringBuilder scanTree(TreeNode A, StringBuilder nodeStr) {
        if(A != null) {
            nodeStr.append(A.val);
            if (A.left == null && A.right == null)
                return nodeStr;
            nodeStr = scanTree(A.left, nodeStr);
            nodeStr = scanTree(A.right, nodeStr);
        } else {
            nodeStr.append("#");
        }
        return nodeStr;

    }

    public boolean isMatch(String a, String b) {
        boolean isMath = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0)) {
                isMath = isEqual(a, b, i);
                if (isMath)
                    return isMath;
            }
        }
        return isMath;
    }

    public boolean isEqual(String a, String b, int begin) {
        int i = 0;
        while(i < b.length() && begin < a.length()) {
            if (a.charAt(begin) == b.charAt(i) || b.charAt(i) == '#'){
                begin ++;
                i ++;
            } else {
                return false;
            }
        }
        if (i == b.length())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String a = "35340";
        String b = "1-4-10-33-1#2-3-4";
        TreeSubStructure solution = new TreeSubStructure();


        System.out.println(solution.isMatch(a, b));

    }

}
