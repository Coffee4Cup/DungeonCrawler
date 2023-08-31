/**
 * represents the coordinates of an entity on board.
 * */
public class Coordinates {
    private int xCoordinate, yCoordinate;

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Coordinates(int xCoordinate, int yCoordinate) {

        if (xCoordinate < 0 || yCoordinate < 0)/*Can't have negative value coordinates in this system*/
            return;

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public int distance(Coordinates Coordinates) {
        return (int)Math.sqrt(Math.pow(this.xCoordinate - Coordinates.xCoordinate, 2) + Math.pow(this.yCoordinate - Coordinates.yCoordinate, 2));
    }

    public Coordinates getAbove() {
        return new Coordinates(this.xCoordinate, this.yCoordinate - 1);
    }
    public Coordinates getBelow() {
        return new Coordinates(this.xCoordinate, this.yCoordinate + 1);
    }
    public Coordinates getToTheRight() {
        return new Coordinates(this.xCoordinate + 1, this.yCoordinate );
    }
    public Coordinates getToTheLeft() {
        return new Coordinates(this.xCoordinate - 1, this.yCoordinate);
    }

    public Coordinates getNewCoordinates(ActionType moveAction) {

        /*NOTE: assumes that the action type is a walk type Action*/

        Coordinates newCoordinates;
        if(moveAction == ActionType.WALK_UP)
        {
            newCoordinates = getAbove();
        }
        else if(moveAction == ActionType.WALK_DOWN)
        {
            newCoordinates = getBelow();
        }
        else if(moveAction == ActionType.WALK_LEFT)
        {
            newCoordinates = getToTheLeft();
        }
        else /*(moveAction == ActionType.WALK_RIGHT) */
        {
            newCoordinates = getToTheRight();
        }

    return newCoordinates;
    }
}
