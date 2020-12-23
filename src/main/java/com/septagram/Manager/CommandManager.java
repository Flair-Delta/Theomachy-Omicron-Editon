package com.septagram.Manager;

import com.septagram.Manager.CommandModule.Convi;
import com.septagram.Manager.Handler.CommandHandler;
import com.septagram.Theomachy.Theomachy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {
    public static Theomachy main;
    public CommandManager(Theomachy t) {
        main=t;
        t.getCommand("t").setExecutor(this);
        t.getCommand("x").setExecutor(this);
        t.getCommand("도박").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] data) {

        if (label.equals("t"))
        {
            if (data.length==0) //설명 보기
            {
                sender.sendMessage(ChatColor.AQUA+("【"+ChatColor.WHITE+"신들의 전쟁 명령어 일람"+ChatColor.AQUA+"】"));
                sender.sendMessage(ChatColor.YELLOW+("/t  start    ")+ChatColor.WHITE+("게임을 시작합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  stop     ")+ChatColor.WHITE+("게임을 중지합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  ability(a)     ")+ChatColor.WHITE+("능력을 설정합니다"));
                sender.sendMessage(ChatColor.YELLOW+("/t  alist ")+ChatColor.WHITE+("적용된 능력을 확인합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  help     ")+ChatColor.WHITE+("자신의 능력을 확인합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  spawn(s) ")+ChatColor.AQUA+("<TeamName>   ")+ChatColor.WHITE+("해당 팀의 스폰지역을 설정합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  team(t)  ")+ChatColor.AQUA+("<TeamName>  ")+ChatColor.RED+("<Player>  ")+ChatColor.WHITE+("플레이어를 팀에 등록합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  info(i)  ")+ChatColor.AQUA+("<TeamName>     ")+ChatColor.WHITE+("해당 팀의 멤버를 확인합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  clear(c) ")+ChatColor.WHITE+("쿨타임을 초기화합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  black    ")+ChatColor.WHITE+("블랙리스트 시스템을 엽니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  set       ")+ChatColor.WHITE+("GUI 설정 시스템을 엽니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  tip       ")+ChatColor.WHITE+("게임에 필요한 TIP을 봅니다."));
                sender.sendMessage(ChatColor.YELLOW+("/t  dia(d)       ")+ChatColor.WHITE+("팀 별로 다이아몬드 블럭을 설정합니다."));
                sender.sendMessage(ChatColor.YELLOW+("/x  ")+ChatColor.RED+("<Player>     ")+ChatColor.WHITE+("해당 플레이어를 자신의 타겟으로 등록합니다"));
                sender.sendMessage(ChatColor.AQUA+"【안내】"+ChatColor.WHITE+"/t help, /t tip, /도박, /x 이외의 명령은 모두 OP 전용입니다.");
            }
            else
                CommandHandler.T_Handler(sender, data, main);
        }

        else if (label.equalsIgnoreCase("x"))
        {
            if (data.length==0) //설명 보기
                sender.sendMessage(ChatColor.YELLOW+("/x  ")+ChatColor.RED+("<Player>     ")+ChatColor.WHITE+("해당 플레이어를 자신의 타겟으로 등록합니다"));
            else
                CommandHandler.X_Handler(sender, data);
        }

        else if (label.equalsIgnoreCase("도박")){
            Convi.Module(sender);
        }

        return true;
    }

}