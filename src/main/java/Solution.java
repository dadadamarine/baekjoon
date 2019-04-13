import java.util.HashSet;

class Solution {

    private static int maxDistantValues;

    Solution() {
        maxDistantValues = 0;
    }

    public int solution(Tree T) {
        if (T == null) {
            return 0;
        }
        makeMaxDistantValuesByDFS(T);
        return maxDistantValues;
    }

    private void makeMaxDistantValuesByDFS(Tree T) {
        makeMaxDistantValuesByDFS(T, new HashSet<Integer>());
    }

    private void makeMaxDistantValuesByDFS(Tree t, HashSet<Integer> hashSet) {
        HashSet<Integer> newHashSet = new HashSet<>(hashSet);
        newHashSet.add(t.x);
        if (t.l != null) {
            makeMaxDistantValuesByDFS(t.l, newHashSet);
        }
        if (t.r != null) {
            makeMaxDistantValuesByDFS(t.r, newHashSet);
        }
        synchronized (this) {
            if (newHashSet.size() > maxDistantValues) {
                maxDistantValues = newHashSet.size();
            }
        }
    }


}

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}