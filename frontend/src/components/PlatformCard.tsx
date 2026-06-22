import type {
  PlatformProfile,
} from "../types/Profile";

type Props = {
  platform: PlatformProfile;
};

export default function PlatformCard({
  platform,
}: Props) {

  if (platform.platform === "CODEFORCES") {
    return (
      <div className="bg-white rounded-xl shadow p-6">

        <h2 className="text-xl font-bold mb-4">
          🏆 Codeforces
        </h2>

        <div className="text-center">

          <h3 className="text-5xl font-bold text-blue-600">
            {platform.currentRating}
          </h3>

          <p className="text-gray-500 mt-1">
            Current Rating
          </p>

          <div className="mt-4 border-t pt-4">

            <p className="text-gray-500">
              Highest Rating
            </p>

            <p className="text-2xl font-semibold">
              {platform.highestRating}
            </p>

          </div>

        </div>

      </div>
    );
  }

  if (platform.platform === "LEETCODE") {
    return (
      <div className="bg-white rounded-xl shadow p-6">

        <h2 className="text-xl font-bold mb-4">
          🧩 LeetCode
        </h2>

        <div className="text-center">

          <h3 className="text-5xl font-bold text-orange-500">
            {platform.totalSolved}
          </h3>

          <p className="text-gray-500 mt-1">
            Problems Solved
          </p>

          <div className="mt-4 border-t pt-4">

            <p className="text-gray-500">
              Username
            </p>

            <p className="font-semibold break-all">
              {platform.username}
            </p>

          </div>

        </div>

      </div>
    );
  }

  if (platform.platform === "GITHUB") {
    return (
      <div className="bg-white rounded-xl shadow p-6">

        <h2 className="text-xl font-bold mb-4">
          💻 GitHub
        </h2>

        <div className="text-center">

          <h3 className="text-5xl font-bold text-gray-700">
            {platform.totalSolved}
          </h3>

          <p className="text-gray-500 mt-1">
            Public Repositories
          </p>

          <div className="mt-4 border-t pt-4">

            <p className="text-gray-500">
              Username
            </p>

            <p className="font-semibold break-all">
              {platform.username}
            </p>

          </div>

        </div>

      </div>
    );
  }

  return null;
}