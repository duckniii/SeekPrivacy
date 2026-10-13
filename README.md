# SeekPrivacy: Activist-Grade Defense Against System-Level Data Surveillance.

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://github.com/duckniii/SeekPrivacy/LICENSE)
[![GitHub release](https://img.shields.io/github/v/release/duckniii/SeekPrivacy)](https://github.com/duckniii/SeekPrivacy/releases/latest)
[![Made with Kotlin](https://img.shields.io/badge/Kotlin-Made%20with-blue.svg)](https://kotlinlang.org/)
[![Security: OWASP MASVS L2](https://img.shields.io/badge/Security-OWASP%20MASVS%20L2-gold.svg)](#-architectural-integrity)
[![Crypto: AES-256-GCM](https://img.shields.io/badge/Crypto-AES--256--GCM-blue.svg)](#-cryptographic-implementation)
[![Forensics: Anti-Shred](https://img.shields.io/badge/Forensics-Anti--Shred-red.svg)](#-forensic-countermeasures)

## ⬇️ Download & Installation



| Source | Status |
|--------|--------|
| **Github Releases** | [![GitHub release](https://img.shields.io/github/v/release/duckniii/SeekPrivacy?label=Latest)](https://github.com/duckniii/SeekPrivacy/releases/download/v3.5.0/seekprivacy-v3.5.0-release.apk) |
| **IzzyOnDroid** | <a href="https://apt.izzysoft.de/fdroid/index/apk/com.seeker.seekprivacy"><img src="https://gitlab.com/IzzyOnDroid/repo/-/raw/master/assets/IzzyOnDroidButtonGreyBorder_nofont.png" height="35" alt="Get it on IzzyOnDroid"></a> |
| **F-Droid** | <a href="https://f-droid.org/packages/com.seeker.seekprivacy"><img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png" height="40" alt="Get it on F-Droid"></a> |
| **Android Freeware** | [![Android Freeware](https://img.shields.io/badge/Download-Android%20Freeware-blue?logo=android)](https://www.androidfreeware.net/download-seekprivacy-apk.html) |
| **OpenAPK** | [![OpenAPK](https://img.shields.io/badge/Download-OpenAPK-orange?logo=android)](https://www.openapk.net/seekprivacy/com.seeker.seekprivacy/) |
| **Appteka** | [![Appteka](https://img.shields.io/badge/Download-Appteka-red?logo=android)](https://appteka.store/apps/bb7r284630) |



## 🛡️ The "No-Trade-Off" Revolution
Apps like social media and other basic tools demand "Storage Access" if you refuse, they break. If you accept, they **spy**.  This creates a painful **trade-off** between **functionality** and **privacy**.


## The SeekPrivacy Shield

SeekPrivacy is built on the principle that your phone's operating system and other apps should be considered **"hostile territory."** It assume the **Android OS is compromised and every other app is a potential spy**. It's architecture ensures that even if a malicious app gains full control of the device, your data remains a cryptographic black box.


**SeekPrivacy eliminates this blackmail.** It provides **multi-layered** defense by isolating data within encrypted sandbox, inaccessible to **other apps**, the **OS**, or **unauthorized physical extraction** - providing **activist grade security** - With the Belief **"Privacy Without the Tradeoff of Ease"**  - even if a malicious app has full device control, it sees **nothing**.


---

**🛡️ HARDENED | 🚫 OFFLINE | ✊ ACTIVIST-GRADE**

---

### 🛠️ Professional File Management Suite 
It's integrated with a full-featured management layer directly into the encrypted state. No more "decrypt-to-organize.". 
The Files/data always stays inside the App, it never leave any trace on System.

| Feature | Description |
| :--- | :--- |
| **Easy to use UI** | Seamless, easy to use UI, without any headache to understand. |
| **Nested Sub-Folders** | Total categorization within the vault. |
| **Instant search** | Find any file across in milliseconds. |
| **Hot-Rename & Move** | Modify file names and locations without breaking encryption. |
| **Share Files** | Share files without ever leaving the trace on phone's system file manager. |
| **Check File Properties** | View properties of files easily. |
| **Live Count** | Total number of files in any folder. |
| **File Import/Export (For Backup)** | Easily backup files anywhere by exporting them and decrypt by importing them. |
| **Preview Thumbnail** | Easily navigate files by their preview thumbnail instead of clicking to know what is what. |
| **Faster Encryption/Decryption** | Encryption/Decryption now uses Tink. |
| **3 Type of App Lock** | Password, pattern, biometric (easily switch between these whenever you want based on your need). |
| **Instant Dev Support** | Email me anytime regarding any issue or new features and expect a response within 12 hours. |

---

### Digital Isolation (Protection from System & Apps)

*   **Hardware-Anchored Storage:** Files are encrypted with `AES-256-GCM` and stored within the app's internal directory. Other apps have no way to even detect the existence of this data, let alone access it. Even in the event of a system-level breach or Root access, the data inside `Encrypted Folder` remains an unreadable encrypted blob that cannot be decrypted without the hardware-bound key.
*   **Hardware-Level Privacy:** By utilizing `FLAG_SECURE`, it block screen-scraping, remote mirroring, and screenshots of your file lists at the hardware level. This defeats spyware attempting to monitor your filenames or activity.
*   **Zero-Persistence RAM:** It don't just "close" keys; it zero them out. Sensitive `CharArrays` are explicitly overwritten with `0x00` in memory, and master keys are wrapped in the **Hardware-Backed KeyStore (TEE)**, making them physically non-exportable.



## ✊ The Activist Grade: "Trauma-Resilient" Defense
In high-risk environments, the greatest threat isn't just a remote hacker it's **Physiological Stress**. When a device is seized or a user is detained, acute trauma causes cognitive blockages. In traditional vaults, forgetting your pattern means your evidence, your contacts, and your protection are effectively dead.

### Secure Dev Last Resort
SeekPrivacy is built for the human element. **Secure Dev Last Resort** is a world-first recovery bridge. By anchoring recovery to the non-exportable `ANDROID_ID` within the device’s physical **Trusted Execution Environment (TEE)** chip, it provide a secure "Extraction Point" for your data.

It eliminate the catastrophic tension of permanent lockouts. This system ensures that even if your memory falters under interrogation or duress, your life's work remains accessible through a verified, hardware-bound recovery path.


---


### Activist-Grade Security Features
| Feature | Description |
| :--- | :--- |
| **Hardware-Backed KeyStore** | Uses RSA-2048/AES-256 GCM. The keys stay in the hardware, not the software. |
| **5-Minute RAM Wipe & Lock** | Sensitive key material and passwords are completely wiped from memory after 5 minutes of inactivity, requiring the app lock again. Once unlocked, file operations proceed without repeated password prompts for a 5-minute active window. |
| **Anti-Forensic Shredder** | Deletion overwrites file headers and the first 1MB with cryptographic random noise to defeat forensic recovery tools. |
| **Stealth Logic** | Screen-recording, screenshots, and "Recent Apps" snapshots are hardware-blocked (`FLAG_SECURE`). |
| **Developer Bypass UI Zero-Tension Recovery** | A recovery system using a hardware-anchored `ANDROID_ID` for secure, encrypted bypass token requests so you never lose data. |
| **🚫 No Internet, No Leaks** | Requests zero network permissions; total offline isolation means your data never leaves your device. |


## Security Protocol
- **Cipher:** AES-256-GCM (Authenticated Encryption)
- **Key Management:** RSA-2048 (Hardware-Backed Android KeyStore)
- **Anti-Mirroring:** Hardware-level `FLAG_SECURE` blocks screenshots and screen recording.




## Activist Threat Model & Defense Scenarios

Forensic & Forced Protection (Protection from Physical Threats)
While the core mission is to neutralize digital surveillance from a compromised OS or spying apps, the defense does not stop at the screen. SeekPrivacy is engineered to bridge the gap between digital security and physical reality. When the threat shifts from a background process to a physical encounter, such as a checkpoint seizure or a forced handover, the app activates high-defense protocols designed to survive forensic extraction and human duress.

When device seizure or a forced handover is imminent, SeekPrivacy shifts into high-defense mode:

| Scenario | Attack Vector | SeekPrivacy Shield |
| :--- | :--- | :--- |
| **Physical Seizure** | Adversary uses forensic hardware (Cellebrite) to "carve" and recover deleted original files. | **Anti-Forensic Shredding:** When importing or deleting, the app triggers a `RandomAccessFile` wipe of the original file. The first **1MB** is overwritten with random noise, destroying the file headers and metadata before the system deletes it. This makes forensic reconstruction of the original data mathematically impossible. |
| **Forced Handover** | You are forced to unlock your device under duress or via compromised OS "bypass" attempts. | **Hardware-Locked Vault:** Access is anchored to the hardware TEE. The master key remains wrapped inside the secure element; without the specific gateway (pattern/pass), the hardware refuses to release the key, even if the OS is compromised or the phone is "unlocked." |
| **Lost Credentials** | High-stress trauma causes you to forget your complex password. | **Secure Developer Bridge:** A world-first recovery protocol. Using your unique `ANDROID_ID` as a hardware anchor, it provides a secure bypass that prevents the permanent loss of life-saving evidence or your life’s work. |




## Building from Source

To build the APK on your local machine, follow these instructions.

### Prerequisites
* **JDK 17**: Ensure you have OpenJDK 17 installed and active.
* **Android SDK**: You need the Android SDK platforms and Build-Tools installed (available via Android Studio).
* **Gradle**: This project uses the included Gradle Wrapper (no separate installation required).

### Setup and Build

1. **Clone the repository:**
   
```bash
   git clone https://github.com/duckniii/SeekPrivacy.git
   cd SeekPrivacy
```

2. **Check Java Version:**
*Verify you are using the correct version by running:*

```bash
  java -version
```
*It should report version 17.*

3. **Run the Build:**
   Execute the following command in the project root:

   **On Linux or macOS:**
   ```bash
   ./gradlew assembleRelease
   ```
   **On Windows (Command Prompt or PowerShell):**
   ```bash
   gradlew.bat assembleRelease
   ```

---

### Screenshots

![Screenshot 1: Dashboard](images/phoneScreenshots/s1.png)
![Screenshot 2: Authentication Options](images/phoneScreenshots/s1-1.png)
![Screenshot 3: Dev](images/phoneScreenshots/dev.png)
![Screenshot 2: Encrypted Folder - Encrypt Files](images/phoneScreenshots/2.png)
![Screenshot 3: Decrypt Files](images/phoneScreenshots/3.png)
![Screenshot 4: Decrypted Folder](images/phoneScreenshots/4.png)
![Screenshot 5: Open, Share, Decrypt Again](images/phoneScreenshots/5.png)
![Screenshot 6: Version2 Categorization n other features overview](images/phoneScreenshots/morefeatures-v2.png)
![Screenshot 7: Pattern](images/phoneScreenshots/pattern.png)


## Logo and Branding

The Seek Privacy logo is property of SeeknWander. You may not use, copy, modify, or redistribute the logo without express permission from [SeeknWander](https://seeknwander.com). All Rights Reserved.

#### Seekprivacy Created By Seeker - Founder of SeeknWander

---

#android #security #privacy #encryption #activism #cryptography #antiforensics #cybersecurity #infosec #dataprivacy #antisurveillance #encryptiontools #open-source
