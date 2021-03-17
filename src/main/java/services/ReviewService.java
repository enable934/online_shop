package services;

import DTOs.ReviewDTO;
import javaBean.Item;
import javaBean.Review;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReviewService {
    private final DBManager dbManager;

    public ReviewService(){
        this.dbManager = new DBManager();
    }

    @org.jetbrains.annotations.NotNull
    public ArrayList<ReviewDTO> selectForItem(Long targetItemId, PrintWriter writer) {
        ArrayList<ReviewDTO> result = new ArrayList<ReviewDTO>();

        try{
            String selectStatement = "select r.id, r.item_id, c.firstname||' '||c.lastname as customer_name, r.rate_score, r.date, r.text\n" +
                    "from review r\n" +
                    "left join customer c\n" +
                    "on r.customer_id = c.id\n" +
                    "where r.item_id = " + targetItemId;

            ResultSet reviews = dbManager.select(selectStatement);
            if(reviews == null)
                return result;
            while(reviews.next()){
                ReviewDTO temp = new ReviewDTO(reviews.getInt(1),
                        reviews.getInt(2),
                        reviews.getString(3),
                        reviews.getInt(4),
                        reviews.getTimestamp(5),
                        reviews.getString(6));

                result.add(temp);
            }
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return result;
    }
}
