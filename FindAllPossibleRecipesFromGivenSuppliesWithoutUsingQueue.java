class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        ArrayList<String> resList = new ArrayList<String>(); 
        boolean[] canRecipeBeMade = new boolean[recipes.length];
        HashSet<String> set = new HashSet<String>();
        for(int i = 0;i<supplies.length;i++){
            set.add(supplies[i]);
        }

        int resListSize = -1; 

        while(resListSize != resList.size()){
            resListSize = resList.size();
            for(int i = 0;i<ingredients.size();i++){
                if(canRecipeBeMade[i] == true)continue;
                boolean doIngredientsExist = true;
                for(int j = 0;j<ingredients.get(i).size();j++){
                    if(!set.contains(ingredients.get(i).get(j))){
                        System.out.println("i : " + i + " j: " + j);
                        System.out.println(set);
                        System.out.println(ingredients.get(i).get(j));
                        doIngredientsExist = false;
                        break;
                    }
                }
                if(doIngredientsExist ==  true){
                    set.add(recipes[i]);
                    resList.add(recipes[i]);
                    canRecipeBeMade[i] = true;
                }else{
                    canRecipeBeMade[i] = false;
                }
            }
        }

        return resList;
    }
}
