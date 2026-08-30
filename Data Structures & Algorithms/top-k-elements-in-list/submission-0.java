class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i:nums){
            mp.put(i, mp.getOrDefault(i, 0)+1);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int i1[], int i2[]){
                return Integer.compare(i1[1], i2[1]);
            }
        });

        for(int i : mp.keySet()){
            int[] arr = {i, mp.get(i)};

            if(pq.size()<k){
                pq.add(arr);
            }
            else if(arr[1]>pq.peek()[1]){
                pq.remove();
                pq.add(arr);
            }
        }
        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++] = pq.remove()[0];
        }
        return ans;
    }
}
