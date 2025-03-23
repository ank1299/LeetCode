class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //It contains recipes that can be made
        ArrayList<String> resList = new ArrayList<String>(); 
        //Queue to store recipes to check
        Queue <Integer> queue = new LinkedList<Integer>();
        boolean[] canRecipeBeMade = new boolean[recipes.length];
        //It contains all the ingredients including all the recipes that can be made
        HashSet<String> set = new HashSet<String>();
        for(int i = 0;i<supplies.length;i++){
            set.add(supplies[i]);
        }

        for(int i = 0;i<recipes.length;i++){
            queue.add(i);
        }

        int resListSize = -1; 

        while(resListSize != resList.size()){
            resListSize = resList.size();
            int queueSize = queue.size();

            while(queueSize-- > 0){
                boolean doIngredientsExist = true;
                int queueHead = queue.poll();
                for(String ingredient : ingredients.get(queueHead)){
                    if(!set.contains(ingredient)){
                        doIngredientsExist = false;
                        break;
                    }
                }
                if(doIngredientsExist ==  true){
                    set.add(recipes[queueHead]);
                    resList.add(recipes[queueHead]);
                    // canRecipeBeMade[i] = true;
                }else{
                    queue.add(queueHead);
                }
            }
        }

        return resList;
    }
}
