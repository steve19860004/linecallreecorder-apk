# LineCallRecorder（LINE 通話錄音）

本 repo 目前有三個版本：OriginOS 專用版、舊版 v1.0、以及新的 v5.0.0（fork 自 CallVault）。

## v5.0.0（實驗性，fork 自 CallVault，GPLv3）

以開源的 **[CallVault](https://github.com/madkongo/CallVault)** 為基底的 fork（授權沿用 **GPLv3**），
改名與套件名為 `com.steve.linecallrec`、改為 GitHub Actions push 自動編譯＋固定簽章。
可透過 Shizuku／內建 ADB 嘗試錄到 LINE 通話雙方聲音。

- 下載：到 **Releases** 的 `v5-build-*` 取 `LineCallRecorder-v5.apk`（目前含語音轉文字，之後會移除以縮小體積）。
- 注意：**實驗性**，成功與否依機型而定；與 v1.0／OriginOS 版簽章不同，需先移除舊版再裝。
- 原始碼在本 repo 根目錄；上游完整說明見 `UPSTREAM-CallVault-README.md`，授權見 `LICENSE`。

---

# LineCallRecorder

## OriginOS 陸版專用 LINE 錄音助手 v0.11（tw.iqoo.linerecorder）

陸版 iQOO／vivo（OriginOS）LINE 通話自動錄音、掛斷後自動命名。內建 Shizuku，免 Root、免電腦。

- 安裝教學網頁：<https://steve19860004.github.io/linecallreecorder-apk/originos/>
- 直接下載：[originos/OriginOS-LINE-Recorder-v0.11.apk](originos/OriginOS-LINE-Recorder-v0.11.apk)
- SHA-256：`473e4346179b5006ad29837e7e5c732f9a73a9efb4c36dc54d45a09bb901c6e4`

## LineCallRecorder（com.steve.linecallrec）

LINE 通話錄音 Android App。

- 使用 Shizuku
- 偵測通話自動開始／停止錄音
- 自訂檔名

### 安裝

下載 [LineCallRecorder.apk](LineCallRecorder.apk)（或到 Releases 頁面下載），在手機上安裝。需先安裝並啟動 Shizuku。
