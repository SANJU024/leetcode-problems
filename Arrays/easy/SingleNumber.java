class SingleNumber {
    public int singleNumber(int[] nums) {
        // Map<Integer,Integer> hm = new HashMap<>();
        // for(int num: nums){
        //     hm.put(num,hm.getOrDefault(num,0)+1);
        // }

        // for(Map.Entry<Integer,Integer> entry: hm.entrySet()){//{2=2,1=1}
        //     if(entry.getValue()==1){
        //         return entry.getKey();
        //     }
        // }
        // return -1;

        int result=0;
        for(int num:nums){
            result^=num;
        }
        return result;
    }
    
}