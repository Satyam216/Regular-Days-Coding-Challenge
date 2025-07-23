package Day61; // problem 1865. Finding Pairs With a Certain Sum
import java.util.Map;
import java.util.HashMap;

class FindSumPairs {

    private int[] arr1;
    private int[] arr2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) { //constructor
        this.arr1 = nums1;
        this.arr2 = nums2;
        this.map = new HashMap<Integer,Integer>();

        for(int num : arr2){
            map.put(num, map.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldValue = arr2[index];
        map.put(oldValue, map.get(oldValue) - 1);
        arr2[index] += val;
        map.put(arr2[index], map.getOrDefault(arr2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num : arr1){
            int remaining = tot - num;
            count += map.getOrDefault(remaining,0);
        }
        return count;
    }
}    

