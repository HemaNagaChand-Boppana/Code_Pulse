import type { Profile } from "../types/Profile";

type Props = {
  profile: Profile;
  onRefresh: () => void;
};

export default function ProfileCard({
  profile,
  onRefresh,
}: Props) {
  return (
    <div className="bg-white rounded-2xl shadow p-6">

      <div className="flex flex-col items-center">

        <div className="w-24 h-24 rounded-full bg-blue-500 text-white flex items-center justify-center text-3xl font-bold">
          {profile.name.charAt(0)}
        </div>

        <h2 className="mt-4 text-2xl font-bold">
          {profile.name}
        </h2>

        <p className="text-gray-500 text-sm mt-1">
          {profile.email}
        </p>

        <div className="w-full border-t my-5"></div>

        <p className="text-gray-600 text-center">
          {profile.college}
        </p>

        <p className="text-gray-500 text-center">
          {profile.branch} • Year {profile.year}
        </p>

        <div className="w-full border-t my-5"></div>

        <div className="text-center">

          <p className="text-gray-500">
            Overall Score
          </p>

          <h3 className="text-5xl font-bold text-blue-600">
            {profile.leaderboardScore}
          </h3>

        </div>

        <button
          onClick={onRefresh}
          className="
            mt-6
            w-full
            bg-blue-600
            text-white
            py-2
            rounded-lg
            hover:bg-blue-700
            transition
          "
        >
          Refresh Stats
        </button>

      </div>

    </div>
  );
}