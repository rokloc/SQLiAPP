<p class="alert">**警告** 細心の注意を払ってください</p>

:::note alert
注意事項
このアプリケーションは教育・デモンストレーション目的のため、意図的にセキュリティ上の脆弱性を含んでいます。実際のプロダクション環境では使用しないでください。
:::

SQLインジェクション再現APP

商品一覧ページ

未発表の商品にSQLiによりアクセスする事を想定

Webアプリにアクセス
http://localhost:8080/product

Foodsカテゴリーで以下に飛ぶ
http://localhost:8080/product/filter?category=Food
SELECT * FROM product WHERE category = 'Food' AND released = '1'

そこに以下を追加すると
http://localhost:8080/product/filter?category=Food'--

DBには以下のようなクエリが飛ぶと予想できる　Foodのあとのクエリをコメントアウトされると
SELECT * FROM product WHERE category = 'Food'[-- AND released = '1'ここがコメントアウト]

SELECT * FROM product WHERE category = 'Food'というクエリが飛び未発表商品にアクセスできてしまう。

〇防ぐ方法
このSQLiは古典的な脆弱性であり、JavaアプリならSpringBootのJPAを継承したメソッドでDB操作をすれば比較的簡単に防げる。

--注意事項
このアプリケーションは教育・デモンストレーション目的のため、意図的にセキュリティ上の脆弱性を含んでいます。実際のプロダクション環境では使用しないでください。





