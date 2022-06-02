package sample.controller;

//import static enumeration.EnumerateWindows.Kernel32.*;
//import static enumeration.EnumerateWindows.Psapi.*;
//import static enumeration.EnumerateWindows.User32DLL.*;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.PointerByReference;

import static sample.controller.OpenWindows.Kernel32.PROCESS_QUERY_INFORMATION;
import static sample.controller.OpenWindows.Kernel32.PROCESS_VM_READ;

public class OpenWindows {
    public static final int MAX_TITLE_LENGTH = 1024;

//    public static void main(String[] args) throws Exception {
//        char[] buffer = new char[MAX_TITLE_LENGTH * 2];
//        User32DLL.GetWindowTextW(User32DLL.GetForegroundWindow(), buffer, MAX_TITLE_LENGTH);
//
//        System.out.println("Active window title: " + Native.toString(buffer));
//
//        PointerByReference pointer = new PointerByReference();
//        User32DLL.GetWindowThreadProcessId(User32DLL.GetForegroundWindow(), pointer);
//        Pointer process = Kernel32.OpenProcess(PROCESS_QUERY_INFORMATION | PROCESS_VM_READ, false, pointer.getValue());
//        Psapi.GetModuleBaseNameW(process, null, buffer, MAX_TITLE_LENGTH);
//        System.out.println("Active window process: " + Native.toString(buffer));
//    }

  public   static class Psapi {
        static { Native.register("psapi"); }
        public static native int GetModuleBaseNameW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);
    }

   public static class Kernel32 {
        static { Native.register("kernel32"); }
        public static int PROCESS_QUERY_INFORMATION = 0x0400;
        public static int PROCESS_VM_READ = 0x0010;
        public static native int GetLastError();
        public static native Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, Pointer pointer);
    }

   public static class User32DLL {
        static { Native.register("user32"); }
        public static native int GetWindowThreadProcessId(HWND hWnd, PointerByReference pref);
        public static native HWND GetForegroundWindow();
        public static native int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);
    }
}
