## Volcano

火山ができるプラグイン

## 動作環境

- Minecraft 1.16.5
- PaperMC 1.16.5

### コマンド

* /volcano
    * start
        * ゲーム開始
    * stop
        * ゲーム終了
    * config modify <設定項目> set <設定値>
        * コンフィグの値を設定する

### コンフィグ設定項目

（）内の値はデフォルト値

* putLavaTick（150）
    * 溶岩が発生する時間(Tick)
* putLavaNum（6）
    * putLavaTickごとに置く溶岩の数(volcanoNum * putLavaNumの数だけマグマが置かれる)
* volcanoNum（10）
    * 同時に生成される火山の数
* volcanoStartRange（15）
    * 火山の開始位置(createVolcanoTypeで指定した生成方法の位置からvolcanoStartRangeの範囲で開始される)
* volcanoGrowTick（60）
    * 火山の成長時間(Tick)
* volcanoWidth（40）
    * 火山となる範囲の幅
* createVolcanoPointOnCoordinate (null)
    * createVolcanoTypeでcoordinateを選択した際の火山の出現位置
