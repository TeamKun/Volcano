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
    * config <設定項目> set <設定値>
        * コンフィグの値を設定する

### コンフィグ設定項目

（）内の値はデフォルト値

* putLavaTick（150）
    * 溶岩が発生する時間(Tick)
* putLavaNum（3）
    * putLavaTickごとに置く溶岩の数(volcanoNum * putLavaNumの数だけマグマが置かれる)
* volcanoNum（1）
    * 同時に生成される火山の数
* volcanoStartRange（15）
    * 火山の開始位置(任意のオンラインプレイヤーからvolcanoStartRangeの範囲で開始される)
* volcanoGrowTick（120）
    * 火山の成長時間(Tick)
* volcanoHeight（80）
    * 火山の高さの最大値
* volcanoWeight（80）
    * 火山となる範囲の幅

* volcanoType（demonstration）
    * 上記パラメータをある程度まとめたもの、以下のパラメータがある
        * demonstration: 説明用、1個の山が作られる
        * normal: demonstrationと同じ山を8個作成する
        * hard: 山を15個作成する。置かれるマグマも多いが、高さが低くなるように設定している




