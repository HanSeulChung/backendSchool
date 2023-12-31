package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17142{
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    final static int EMPTY = 0;
    final static int WALL = 1;
    final static int UNACTIVEVIRUS = 2;
    final static int ACTIVEVIRUS = 3;
    static int N;

    static int activevirusCnt;
    static int emptyCnt;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> virusPoints;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        activevirusCnt = Integer.parseInt(st.nextToken());
        virusPoints = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == EMPTY) { // 빈 공간인지 카운팅
                    emptyCnt++;
                } else if (map[i][j] == UNACTIVEVIRUS) {  // 비활성화 바이러스 포인트를 Arraylist에 저장
                    virusPoints.add(new Point(j, i));   // x는 col, y는 row로 저장
                }
            }
        }

        if (emptyCnt == 0) { // 빈공간이 없으면 virus를 확산 시킬 수 없음.
            System.out.println(0);
            return;
        } else {
            combination(0, 0);
        }

    }

    public static void combination(int start, int cnt) {
        if (cnt == activevirusCnt) { // 활성화 시킨 바이러스의 개수가 activevirusCnt값이 같으면 경우의 수 종료, bfs 실행
            bfs(); // bfs 시작
            return;
        }

        for (int i = start; i < virusPoints.size(); i++) {
            Point virusPoint = virusPoints.get(i);
            if (!visited[virusPoint.x][virusPoint.y]) {
                visited[virusPoint.x][virusPoint.y] = true; // 활성화 처리
                combination(start + 1, cnt + 1); // 다시 경우의 수 카운팅
                visited[virusPoint.x][virusPoint.y] = false; // 비활성화 처리
            }
        }
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] virusVisited = new boolean[N][N];

        for (int i = 0; i < virusPoints.size(); i++) {
            Point p = virusPoints.get(i);
            if (visited[p.x][p.y]) { // 활성화 시킨 바이러스 일 경우 q에 추가함
                q.add(new Point(p.x, p.y));
            }
        }

        int zeroCnt = 0; // 비어있는 공간
        int time = 0;
        while (!q.isEmpty()) {
            time++;
            Point point = q.poll();
            int pointX = point.x;
            int pointY = point.y;

            for (int i = 0; i < dirX.length; i++) {
                int xNext = pointX + dirX[i];
                int yNext = pointY + dirY[i];

                if (xNext < 0 || xNext >= N || yNext < 0 || yNext > N) {
                    continue;
                }
                if(!visited[xNext][yNext] && map[xNext][yNext] == WALL) {
                    continue;
                }

                if(!visited[xNext][yNext] && map[xNext][yNext] == EMPTY) {
                    zeroCnt++;
                    visited[xNext][yNext] = true;
                    q.offer(new Point(xNext, yNext));
                } else if (!visited[xNext][yNext] && map[xNext][yNext] == UNACTIVEVIRUS) {
                    visited[xNext][yNext] = true;
                    q.offer(new Point(xNext, yNext));
                }
            }
        }

        if(emptyCnt != zeroCnt) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(time);
            return;
        }
    }
}

