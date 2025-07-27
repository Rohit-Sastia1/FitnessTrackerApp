# FitnessTrackerApp

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: ROHIT SASTIA

*INTERN ID*: CT04DH928

*DOMAIN*: ANDROID DEVELOPMENT

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTHOSH

# FitnessTrackerApp

## 📱 Overview

**FitnessTrackerApp** is a lightweight and intuitive Android application designed to help users stay fit by tracking their daily physical activity using the phone’s built-in sensors. The app focuses on three key metrics—**step count**, **distance walked**, and **calories burned**—offering users valuable insights into their movement throughout the day. With a user-friendly interface and real-time updates, the app is well-suited for casual walkers, fitness enthusiasts, and anyone looking to monitor their activity levels in a simple and efficient way.

The app utilizes Android's `SensorManager` and `TYPE_STEP_COUNTER` sensor to measure physical activity without requiring external devices like wearables or GPS. This allows it to function efficiently even in offline mode and on most modern Android smartphones.

---

## 🚀 How It Works

The core functionality of FitnessTrackerApp revolves around real-time step tracking. When the app is launched, it accesses the device's hardware sensor responsible for counting steps. Every time a step is detected, the count is updated instantly on the screen. Using a fixed average step length (e.g., 0.78 meters per step), the app calculates the approximate distance walked in kilometers.

Additionally, calories burned are calculated based on a standard formula (e.g., 0.04 calories per step). These values are displayed clearly on the main screen and are also visualized using a pie chart created with MPAndroidChart. This chart dynamically updates to show a proportional breakdown of the user’s steps, distance, and calories, offering an at-a-glance overview of physical activity.

The app registers and unregisters sensor listeners during the appropriate activity lifecycle events (onResume and onPause) to preserve battery life and system resources.

---

## 🧱 Architecture

- Built with Java and Android SDK  
- Uses Android’s Sensor API for physical activity tracking  
- Employs MPAndroidChart for data visualization  
- Clean, modern UI using Material Design principles  

---

## 🔧 Features

- **Real-time step tracking** using built-in sensors  
- **Automatic calculation of distance and calories burned**  
- **Live pie chart** showing the breakdown of activity  
- **Lightweight and battery-efficient** due to optimized sensor handling  
- **Works offline**, no need for GPS or network connectivity  
- **Responsive UI** with easy-to-read text and interactive visual feedback  

---

## 📋 Minimum Requirements

- Android Studio Hedgehog or newer  
- Android SDK version 27 or above  
- A real Android device with a step counter sensor  
- No internet connection required for app functionality  

---

## 💻 Setup Instructions

1. Clone or download the repository from GitHub.  
2. Open the project in Android Studio.  
3. Sync Gradle and allow dependencies to download.  
4. Connect a real Android device (sensor not available on emulator).  
5. Run the app and start moving to see step count, distance, and calories update.  

The app does not require special permissions since it only accesses the step counter, which does not fall under dangerous permission categories. No location or background activity permissions are necessary.

---

## 📊 Data Visualization

To enhance user experience and make activity tracking more engaging, FitnessTrackerApp includes a pie chart using the popular MPAndroidChart library. This chart provides a visual breakdown of steps taken, distance walked, and calories burned—updated every time sensor data is received. Users can visually interpret how their activity progresses throughout the day with a clean and colorful chart UI.

---

## 🎯 Future Enhancements

- Add historical tracking and day-wise logs  
- Support for exporting data to CSV or cloud storage  
- Integration with GPS for route tracking  
- Include heart rate sensor support for compatible devices  
- Add notifications or goals for motivation  
- Enable dark mode and theming options  

---


## 🙋‍♂️ Acknowledgements

- Android Developers Documentation  
- MPAndroidChart Library by Philipp Jahoda  
- Stack Overflow community for debugging support  

---

## Output

![Image](https://github.com/user-attachments/assets/dd63bf90-913a-4f2f-9ed0-b9cb70846318)
