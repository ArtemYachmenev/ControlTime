package sample.controller;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.win32.StdCallLibrary;

import static com.sun.jna.platform.win32.WinUser.*;

// see http://java-native-access.github.io/jna/4.0/javadoc/
public class OpenWindows2 {
    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
        boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);
        int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);

        int GetWindowTextA(HWND hWnd, int gwlStyle);
    }

//    public static void main(String[] args) {
//        final User32 user32 = User32.INSTANCE;
//        user32.EnumWindows(new WNDENUMPROC() {
//            int count = 0;
//            @Override
//            public boolean callback(HWND hWnd, Pointer arg1) {
//                byte[] windowText = new byte[512];
//                user32.GetWindowTextA(hWnd, windowText, 512);
//                String wText = Native.toString(windowText);
//
//                // get rid of this if block if you want all windows regardless of whether
//                // or not they have text
//                if (wText.isEmpty()) {
//                    return true;
//                }
//
//                System.out.println("Found window with text " + hWnd + ", total " + ++count
//                        + " Text: " + wText);
//
//                int visibleWindow = WS_BORDER | WS_VISIBLE;
//
//                if ((user32.GetWindowTextA(hWnd, GWL_STYLE) & visibleWindow) == visibleWindow)
//                {
//                    // если истина, то окно видно
//                    System.out.println("kdsfikjsdf");
//                }
//                return true;
//            }
//        }, null);
//
//
//
//    }

    public static class User32DLL {
        static { Native.register("user32"); }
        public static native int GetWindowThreadProcessId(HWND hWnd, PointerByReference pref);
        public static native HWND GetForegroundWindow();
        public static native int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);
        public void get(){

        }
    }

}
