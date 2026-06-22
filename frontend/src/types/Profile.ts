export interface PlatformProfile {
  platform: string;
  username: string;
  currentRating: number;
  highestRating: number;
  totalSolved: number;
}

export interface Profile {
  userId: number;
  name: string;
  email: string;
  college: string;
  branch: string;
  year: number;
  leaderboardScore: number;
  platforms: PlatformProfile[];
}