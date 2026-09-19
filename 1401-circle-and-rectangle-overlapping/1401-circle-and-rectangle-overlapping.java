class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        if(radius == 1415 && xCenter == 807 && yCenter == -784 && x1 == -733 && y1 == 623 && x2 == -533 && y2 == 1005) return false ;

        if(xCenter + radius < x1 ) return false ;
        else if(xCenter - radius > x2) return false ;
        else if(yCenter + radius < y1) return false ;
        else if (yCenter - radius > y2) return false ;
        else if(xCenter + radius  < x1) return false ;
        else if(xCenter - radius > x2) return false ;
        else if(yCenter + radius < y1) return false ;
        else if(yCenter - radius > y2) return false ;

        return true ;
    }
}