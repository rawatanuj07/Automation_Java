import 'package:flutter/material.dart';
import 'package:http/http.dart';
import 'dart:convert';

class WorldTime {
  String location;
  String time = "";
  String flag;
  String url;
  WorldTime({required this.location, required this.flag, required this.url});
  Future getTime() async {
    Uri urs = Uri.parse('https://worldtimeapi.org/api/timezone/$url');

    Response response = await get(urs);
    Map data = jsonDecode(response.body);
    // print(data);

    var datetime = data['datetime'];
    var offset = data['utc_offset'].substring(1, 3);

    // print(datetime);
    // print(offset);

    DateTime now = DateTime.parse(datetime);
    now = now.add(Duration(hours: int.parse(offset)));
    time = now.toString();
  }
}
