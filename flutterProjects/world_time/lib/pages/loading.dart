import 'package:world_time/services/worldTime.dart';
import 'package:flutter/material.dart';
import 'dart:convert';

class Loading extends StatefulWidget {
  const Loading({super.key});

  @override
  State<Loading> createState() => _LoadingState();
}

class _LoadingState extends State<Loading> {
  String time = "loading";

  Future<dynamic> setupWorldTime() async {
    WorldTime instance =
        WorldTime(location: 'Delhi', flag: "INDIA", url: 'Asia/Kolkata');
    await instance.getTime();
    print(instance.getTime());
    setState(() {
      time = instance.time;
    });
  }

  @override
  void initState() {
    super.initState();
    setupWorldTime();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(50.0),
        child: Text(time),
      ),
    );
  }
}
