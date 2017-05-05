import org.junit.Test;

import java.util.*;

public class StockTrading {

    @Test
    public void test() throws Exception {
        StockTrader stockTrader = new StockTrader();
        InvestmentAnalyzer analyzer = new InvestmentAnalyzer(stockTrader);

        //create query

        for (int i = 0; i < 100000; i++) {
            analyzer.handleQuery(createQuery());
        }

        //analyze
        analyzer.analyzeQueries();

        //handle stock tradings

        stockTrader.handleTradings();
    }

    private InvestmentQuery createQuery() {
        return new InvestmentQuery(new Random().toString(), new Date(), new Random().nextInt(), UUID.randomUUID());
    }


}

class InvestmentQuery implements Comparable<InvestmentQuery> {

    public final String stockId;
    public final Date queryTime;
    public final Integer priority;
    public final UUID inverstor;

    InvestmentQuery(String stockId, Date queryTime, Integer priority, UUID investor) {
        this.stockId = stockId;
        this.queryTime = queryTime;
        this.priority = priority;
        this.inverstor = investor;
    }

    public int compareTo(InvestmentQuery other) {

        if (other == null) {
            return 0;
        }
        int i = this.priority.compareTo(other.priority);
        if (i != 0) {
            return i;
        }
        return this.stockId.compareTo(other.stockId);
    }
}

class InvestmentAnalyzer {

    class RatingCacheElement {
        private final String stockId;
        private final int rating;

        RatingCacheElement(String stockId, int rating) {
            this.stockId = stockId;
            this.rating = rating;
        }
    }

    List<InvestmentQuery> queries = new ArrayList<InvestmentQuery>();
    List<RatingCacheElement> cacheRatings = new ArrayList<RatingCacheElement>();

    private StockTrader stockTrader;

    InvestmentAnalyzer(StockTrader stockTrader) {

        this.stockTrader = stockTrader;
    }

    void handleQuery(InvestmentQuery query) {
        queries.add(query);
    }

    void analyzeQueries() {


        while (queries.size() > 0) {
            int rating;
            InvestmentQuery firstPriorityQueue = getFirstPriorityQueue(queries);

            RatingCacheElement ratingCacheElement = null;
            for (RatingCacheElement cacheElement : cacheRatings) {

                if (cacheElement.stockId.equals(firstPriorityQueue.stockId)) {
                    ratingCacheElement = cacheElement;
                }
            }

//            RatingCacheElement ratingCacheElement = cacheRatings.stream().
//                    filter(x -> x.stockId == firstPriorityQueue.stockId).findAny().orElse(null);
//            ;//collect the output and convert streams to a List


            if (ratingCacheElement != null) {
                rating = ratingCacheElement.rating;
            } else {
                rating = calculateRating(firstPriorityQueue.stockId);
                cacheRatings.add(new RatingCacheElement(firstPriorityQueue.stockId, firstPriorityQueue.priority));
            }

            if (rating > 80) {
                stockTrader.enqueueStockForTrading(firstPriorityQueue);
            }

        }

    }

    private int calculateRating(String stockId) {
        return 0;
    }

    private InvestmentQuery getFirstPriorityQueue(List<InvestmentQuery> queries) {

        InvestmentQuery minQuery = null;
        for (InvestmentQuery q : queries) {
            if (minQuery == null && q.compareTo(minQuery) < 0) {

                minQuery = q;
            }

        }
        queries.remove(minQuery);
        return minQuery;
    }
}

class StockTrader {

    List<InvestmentQuery> stocksToTrade = new ArrayList<InvestmentQuery>();

    public void handleTradings() {

        while (stocksToTrade.size() > 0) {
            //process
            InvestmentQuery investmentQuery = stocksToTrade.get(0);

            //remove
            stocksToTrade.remove(0);
        }

    }

    public void enqueueStockForTrading(InvestmentQuery firstPriorityQueue) {

        stocksToTrade.add(firstPriorityQueue);


    }
}


