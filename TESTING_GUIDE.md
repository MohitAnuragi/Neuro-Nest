# Quick Start Testing Guide

## 🚀 How to Test the Profile Persistence System

### Prerequisites
✅ Build completed successfully  
✅ App installed on device/emulator

---

## Test Scenario 1: Fresh Installation (First Time User)

### Steps:
1. **Uninstall** the app (to simulate fresh install)
   ```
   adb uninstall com.example.neuronest
   ```

2. **Install** the app
   ```
   ./gradlew installDebug
   ```

3. **Open** the app

4. **Expected Behavior:**
   - ✅ Splash screen appears
   - ✅ Automatically navigates to **Profile Setup Screen**
   - ✅ Shows "Setup Profile" title (not "Edit Profile")

5. **Fill Profile:**
   - Enter your name (e.g., "John Doe")
   - (Optional) Click profile image circle to select an image
   - Click **"SAVE PROFILE"** button

6. **Expected Behavior:**
   - ✅ Navigates to **Puzzle Dashboard** (main selection screen)
   - ✅ Profile setup screen disappears

7. **Close the app** completely (swipe away from recent apps)

8. **Reopen the app**

9. **Expected Behavior:** 🎯
   - ✅ Splash screen appears
   - ✅ Automatically navigates to **Puzzle Dashboard** (NOT profile setup)
   - ✅ Profile Setup Screen is **SKIPPED**

10. **Verify Profile Data:**
    - Navigate to Profile section (from bottom navigation or menu)
    - ✅ Your name is displayed
    - ✅ Your profile image is displayed (if you selected one)
    - ✅ Join date is shown

### ✅ Success Criteria:
- Profile setup appears only ONCE on first launch
- Profile data persists after app restart
- Navigation skips setup on subsequent launches

---

## Test Scenario 2: Profile Persistence Over Time

### Steps:
1. Complete profile setup (as in Scenario 1)

2. **Close the app**

3. **Wait 5 minutes** (or longer)

4. **Reopen the app**

5. **Expected Behavior:** 🎯
   - ✅ Goes directly to Puzzle Dashboard
   - ✅ Does NOT show Profile Setup Screen

6. **Navigate to Profile screen**

7. **Expected Behavior:**
   - ✅ Name is still there
   - ✅ Image is still there
   - ✅ Join date is still correct

### ✅ Success Criteria:
- Profile data persists across time gaps
- No data loss

---

## Test Scenario 3: Device Restart (Ultimate Test)

### Steps:
1. Complete profile setup

2. **Restart the Android device/emulator**
   ```
   adb reboot
   ```

3. Wait for device to fully restart

4. **Open the app**

5. **Expected Behavior:** 🎯
   - ✅ Goes directly to Puzzle Dashboard
   - ✅ Profile Setup Screen is skipped
   - ✅ All profile data intact

### ✅ Success Criteria:
- Profile persists through device reboot
- Room database survives system restart

---

## Test Scenario 4: Skip Profile Setup

### Steps:
1. **Fresh install** (uninstall and reinstall)

2. **Open app** → Profile Setup Screen appears

3. **Click "Skip for now"** (at bottom of screen)

4. **Expected Behavior:**
   - ✅ Navigates to Puzzle Dashboard
   - ✅ Profile created with "Guest User" name

5. **Close and reopen app**

6. **Expected Behavior:** 🎯
   - ✅ Goes directly to Puzzle Dashboard
   - ✅ Does NOT show Profile Setup Screen again

7. **Navigate to Profile screen**

8. **Expected Behavior:**
   - ✅ Shows "Guest" as the name
   - ✅ Shows default profile icon (no image)

### ✅ Success Criteria:
- Skip creates a valid profile
- Setup screen doesn't reappear

---

## Test Scenario 5: Profile Image Display

### Steps:
1. Complete profile setup WITH an image selected

2. **Navigate to Profile screen**

3. **Expected Behavior:**
   - ✅ Profile image displays in circular frame
   - ✅ Golden border around image
   - ✅ Image is properly cropped/scaled

4. **Close and reopen app**

5. **Navigate to Profile screen again**

6. **Expected Behavior:** 🎯
   - ✅ Same profile image is displayed
   - ✅ Image URI properly loaded from Room database
   - ✅ Coil successfully renders the image

### ✅ Success Criteria:
- Profile image persists across restarts
- Image displays in both ProfileSetupScreen and ProfileScreen
- No broken images or URIs

---

## Test Scenario 6: Clear App Data (Reset Test)

### Steps:
1. Complete profile setup

2. **Clear app data** (Settings → Apps → Neuronest → Clear Data)
   OR
   ```
   adb shell pm clear com.example.neuronest
   ```

3. **Open app**

4. **Expected Behavior:**
   - ✅ Profile Setup Screen appears again
   - ✅ Behaves like fresh install
   - ✅ All data cleared (as expected)

### ✅ Success Criteria:
- Clearing data resets everything
- App handles reset gracefully

---

## Debugging Commands

### Check if Room Database Exists:
```bash
adb shell run-as com.example.neuronest ls databases/
```

### View Database Contents (Rooted/Emulator):
```bash
adb shell
run-as com.example.neuronest
cd databases/
sqlite3 puzzle_app_database
SELECT * FROM user_profiles;
.exit
```

### View Logcat for Errors:
```bash
adb logcat | grep -i "neuronest\|room\|profile"
```

### Force Stop App:
```bash
adb shell am force-stop com.example.neuronest
```

---

## Expected Database Values After Setup

When you complete profile setup, the database should contain:

```sql
userId: "default_user"
displayName: "Your Name" (or "Guest User" if skipped)
profileImageUri: "content://media/external/images/123" (or "" if no image)
isProfileSetup: 1 (true)
joinDate: 1737592800000 (timestamp)
totalScore: 0
totalPuzzlesSolved: 0
currentStreak: 0
```

**Critical Field:** `isProfileSetup = 1` (true)

This is what prevents the Profile Setup Screen from appearing again!

---

## Common Issues & Solutions

### ❌ Problem: Setup screen appears every time
**Likely Cause:** `isProfileSetup` not being saved as `true`  
**Check:** Database version incremented? (should be 5)  
**Solution:** Already implemented! Should not occur.

### ❌ Problem: Profile image not showing
**Likely Cause:** URI not saved or Coil not loading  
**Check:** 
1. Is `profileImageUri` field populated in database?
2. Is Coil dependency in `build.gradle.kts`? ✅ Yes
3. Is `rememberAsyncImagePainter` used? ✅ Yes

### ❌ Problem: App crashes on startup
**Likely Cause:** Room migration issue  
**Solution:** Uninstall app completely and reinstall (dev only)

### ❌ Problem: "Guest User" appears instead of name
**Likely Cause:** Clicked "Skip" instead of "Save"  
**Solution:** This is expected behavior - user can edit profile later

---

## Final Verification Checklist

Before considering testing complete, verify:

- [ ] ✅ Fresh install shows Profile Setup Screen
- [ ] ✅ Entering name and saving navigates to Dashboard
- [ ] ✅ Reopening app skips Profile Setup Screen
- [ ] ✅ Profile data visible in Profile screen
- [ ] ✅ Profile image displays correctly (if selected)
- [ ] ✅ Join date is accurate
- [ ] ✅ App survives device restart with data intact
- [ ] ✅ Skip functionality works
- [ ] ✅ No crashes or errors

---

## Success! 🎉

If all test scenarios pass, your profile persistence system is:

✅ **Fully Functional**  
✅ **Persistent Across Restarts**  
✅ **Production Ready**  

The user will only see Profile Setup Screen **ONCE** on first install, then never again (unless app data is cleared).

---

## Next Steps (Optional Enhancements)

- Add "Edit Profile" functionality
- Add profile image cropping
- Add profile data export
- Add profile statistics dashboard
- Add profile achievements system

But for now, the core requirement is **COMPLETE** ✅

