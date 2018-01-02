import java.util.*;

/**
 * Created by ddning on 2017/12/10.
 */
class WordFilter {
    class Compare implements Comparator<Integer> {
        private int[] cost;
        public Compare(int[] cost){
            this.cost = cost;
        }
        @Override
        public int compare(Integer o1, Integer o2) {
            return (int) cost[o1] - cost[o2];
        }
    }

//    public int networkDelayTime(int[][] times, int N, int K) {
//        int ret = 0;
//        int graph[][] = new int[N][N];
//        int cost[] = new int[N];
////        int tmp[] = new int[N];
//        Compare cmp = new Compare(cost);
//        List<Integer> q = new ArrayList<Integer>();
//        Arrays.fill(cost, Integer.MAX_VALUE);
//        cost[K-1] = 0;
//        for(int i = 0; i < N;i ++){
//            Arrays.fill(graph[i],Integer.MAX_VALUE);
//        }
//        for(int i = 0; i < times.length; i++){
//            graph[times[i][0]-1][times[i][1]-1] = times[i][2];
//        }
//        int[] visited = new int[N];
//        Arrays.fill(visited,-1);
//        q.add(K-1);
//        visited[K-1] = 1;
//        while(!q.isEmpty()){
//            q.sort(cmp);
//            int top = q.get(0);
//            q.remove(0);
//            visited[top] = 1;
//            for(int i = 0; i < N; i++){
//                if(visited[i] == -1 && graph[top][i] != Integer.MAX_VALUE){
//                    if(cost[i] > cost[top] + graph[top][i]){
//                        cost[i] = cost[top] + graph[top][i];
//                        if(!q.contains(i)){
//                            q.add(i);
//                        }
//                    }
//                }
//            }
//        }
//        for(int i = 0; i < N; i++){
//            if(cost[i] == Integer.MAX_VALUE)
//                return -1;
//            else if(cost[i] > ret)
//                ret = cost[i];
//        }
//        return ret;
//    }
    class Node{
        List<Integer> val = new ArrayList<>();
        Node[] next = new Node[26];

        public void add1(String str,int len,int index){

            this.val.add(index);
            if(len == str.length())
                return ;
            if(this.next[str.charAt(len)-'a'] == null){
                this.next[str.charAt(len)-'a'] = new Node();
            }
            this.next[str.charAt(len)-'a'].add1(str,len+1,index);
        }

        public void add2(String str,int len,int index){

            this.val.add(index);
            if(len == -1)
                return ;
            if(this.next[str.charAt(len)-'a'] == null){
                this.next[str.charAt(len)-'a'] = new Node();
            }
            this.next[str.charAt(len)-'a'].add2(str,len-1,index);
        }

        public List<Integer> find1(String str) {
            if(str.equals(""))
                return this.val;
            if(this.next[str.charAt(0)-'a'] == null)
                return null;
            return this.next[str.charAt(0)-'a'].find1(str.substring(1));
        }
    public List<Integer> find2(String str) {
        if(str.equals(""))
            return this.val;
        if(this.next[str.charAt(str.length()-1)-'a'] == null)
            return null;
        return this.next[str.charAt(str.length()-1)-'a'].find2(str.substring(0,str.length()-1));
    }
    }
    private Node pre = new Node();
    private Node bhd = new Node();
    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++){
//            pre.val.add(i);
            pre.add1(words[i],0,i);
            bhd.add2(words[i],words[i].length()-1,i);
        }

    }

    public int f(String prefix, String suffix) {
        List<Integer> preIndex = pre.find1(prefix);
        List<Integer> suffixIndex = bhd.find2(suffix);

        if(preIndex == null || suffixIndex == null)
            return -1;
        int p = preIndex.size()-1,s = suffixIndex.size()-1;
        while(p >= 0 && s >= 0){
            if(preIndex.get(p).equals(suffixIndex.get(s)))
                return preIndex.get(p);
            else if(preIndex.get(p) > suffixIndex.get(s)){
                p--;
            }
            else{
                s--;
            }
        }
        return -1;

    }
    public static void main(String[] args){
        WordFilter s = new WordFilter(new String[]{"apple"});
        int ret = s.f("a","e");
        System.out.println(ret);
//        char ret = s.nextGreatestLetter(letter,'c');
//        System.out.print(ret);
    }
}