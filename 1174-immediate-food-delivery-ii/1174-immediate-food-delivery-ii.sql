SELECT
ROUND(
    SUM(IF(order_date = customer_pref_delivery_date, 1, 0)) * 100 / COUNT(DISTINCT customer_id), 2) as immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN
    (
        SELECT d.customer_id, min(order_date) as first_order
        FROM Delivery d
        GROUP BY d.customer_id
    );